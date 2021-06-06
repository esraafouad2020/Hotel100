package com.fcih.swing.hotel.dao.impl.jdbc;

import com.fcih.swing.hotel.dao.EntityManager;
import com.fcih.swing.hotel.entity.annotation.Entity;
import com.fcih.swing.hotel.dao.impl.jdbc.connection.impl.OracleConnection;
import com.fcih.swing.hotel.entity.annotation.Column;
import com.fcih.swing.hotel.entity.annotation.Join;
import com.fcih.swing.hotel.model.Model;
import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleEntityManager<E> implements EntityManager<E> {

    Connection connection;
    private final Map<Class, Class> primitiveClassName;

    public OracleEntityManager() throws ClassNotFoundException, SQLException {
        connection = OracleConnection.getOracleConnection().getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HOTEL_RESERVATION", "HOTEL_RESERVATION");

        primitiveClassName = new HashMap<>();
        primitiveClassName.put(Integer.class, int.class);
        primitiveClassName.put(Float.class, float.class);
        primitiveClassName.put(Boolean.class, int.class);
        primitiveClassName.put(Short.class, short.class);
        primitiveClassName.put(Byte.class, byte.class);
        primitiveClassName.put(Long.class, long.class);
        primitiveClassName.put(Double.class, double.class);
        primitiveClassName.put(Character.class, String.class);
        primitiveClassName.put(String.class, String.class);
        primitiveClassName.put(Date.class, Date.class);
    }

    @Override
    public void add(E entity) throws Exception {
        int i = 1;
        PreparedStatement ps = null;

        ps = connection.prepareStatement(prepareInsertIntoQuery(entity));

        Map<String, Map<Object, Class>> fieldsNameValueType = prepareFieldValue(entity);

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.getName().equalsIgnoreCase("id")) {
                continue;
            }

            Map.Entry<Object, Class> fieldValueType = fieldsNameValueType.get(field.getName()).entrySet().iterator().next();
            Class fieldType = fieldValueType.getValue();
            Object fieldValue = fieldValueType.getKey();

            if (fieldValue == null) {
                continue;
            }

            Method psSetterMethod = ps.getClass().getDeclaredMethod("set" + fieldType.getSimpleName().substring(0, 1).toUpperCase() + fieldType.getSimpleName().substring(1), new Class[]{int.class, fieldType});
            
            if (psSetterMethod != null) {
                psSetterMethod.setAccessible(true);
                psSetterMethod.invoke(ps, i++, fieldValue);
            }
        }

        ps.executeUpdate();

        try {
            if (ps != null) {
                ps.close();
            }//TODO close connection
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String prepareInsertIntoQuery(E entity) throws Exception {
        int fieldSize = 0;
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (entity.getClass().isAnnotationPresent(Entity.class)) {
            Annotation annotation = entity.getClass().getAnnotation(Entity.class);

            if (annotation instanceof Entity) {
                query.append(((Entity) annotation).value()).append(" (");
            }
        } else {
            query.append(entity.getClass().getSimpleName()).append(" (");
        }

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.getName().equalsIgnoreCase("id")) {
                continue;
            }

            field.setAccessible(true);
            if (field.get(entity) == null) {
                continue;
            }

            String columnName = "";

            if (field.isAnnotationPresent(Column.class)) {
                Annotation annotation = field.getAnnotation(Column.class);

                if (annotation instanceof Column) {
                    columnName = ((Column) annotation).value();
                }

            } else {
                columnName = field.getName();
            }

            query.append(columnName).append(",");
            fieldSize++;
        }

        query.deleteCharAt(query.length() - 1);
        query.append(") values(");

        for (int i = 0; i < fieldSize; i++) {
            query.append("?,");
        }

        query.deleteCharAt(query.length() - 1);
        query.append(")");

        return query.toString();
    }

    @Override
    public int update(E entity) throws Exception {
        return connection.prepareStatement(prepareUpdateQuery(entity)).executeUpdate();
    }

    private String prepareUpdateQuery(E entity) throws Exception {
        Object id = null;
        StringBuilder query = new StringBuilder("UPDATE ");

        if (entity.getClass().isAnnotationPresent(Entity.class)) {
            Annotation annotation = entity.getClass().getAnnotation(Entity.class);

            if (annotation instanceof Entity) {
                query.append(((Entity) annotation).value()).append(" SET ");
            }
        } else {
            query.append(entity.getClass().getSimpleName()).append(" SET ");
        }

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.getName().equalsIgnoreCase("id")) {
                field.setAccessible(true);
                id = field.get(entity);

                if (id == null) {
                    throw new Exception("ID not found");
                }

                continue;
            }

            field.setAccessible(true);
            
            String columnName = "";

            if (field.isAnnotationPresent(Column.class)) {
                Annotation annotation = field.getAnnotation(Column.class);

                if (annotation instanceof Column) {
                    columnName = ((Column) annotation).value();
                }

            } else {
                columnName = field.getName();
            }

            query.append(columnName).append(" = ");
            
            Object value = field.get(entity);
            
            if(value instanceof String) {
                query.append("'").append(value).append("'");
            } else {
                query.append(value);
            }
            query.append(" , ");
        }

        query.deleteCharAt(query.length() - 2);
        query.append(" WHERE id = ").append(id);

        return query.toString();
    }

    private Map<String, Map<Object, Class>> prepareFieldValue(E entity) throws Exception {

        Map<String, Map<Object, Class>> fieldNameValueTypeMap = new HashMap<>();

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {

            Map<Object, Class> fieldValueTypeMap = new HashMap<>();

            if (field.getName().equalsIgnoreCase("id")) {
                continue;
            }

            //TODO : change to field.get(entity)
            String getX = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            Method fieldGetterMethod = entity.getClass().getDeclaredMethod(getX, null);
            Object o = fieldGetterMethod.invoke(entity, null);

            //if field type refrence from Onther Object
            if (field.isAnnotationPresent(Join.class)) {
                Model m = (Model) o;
                fieldValueTypeMap.put(m.getId(), int.class);
            } //if field type is simple
            else {
                Class dataType = primitiveClassName.get(Class.forName(field.getType().getName()));
                fieldValueTypeMap.put(o, dataType);
            }

            fieldNameValueTypeMap.put(field.getName(), fieldValueTypeMap);

        }

        return fieldNameValueTypeMap;
    }

    @Override
    public int delete(E entity) throws Exception {
        PreparedStatement ps = null;
        int i = 1;

        StringBuilder query = new StringBuilder("DELETE FROM ");
        
        if (entity.getClass().isAnnotationPresent(Entity.class)) {
            Annotation annotation = entity.getClass().getAnnotation(Entity.class);

            if (annotation instanceof Entity) {
                query.append(((Entity) annotation).value()).append(" WHERE id = ");
            }
        } else {
            query.append(entity.getClass().getSimpleName()).append(" WHERE id = ");
        }

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.getName().equalsIgnoreCase("id")) {
                field.setAccessible(true);
                Object id = field.get(entity);

                if (id == null) {
                    throw new Exception("ID not found");
                }

                query.append(id);
                break;
            }
        }

        ps = connection.prepareStatement(query.toString());

        i = ps.executeUpdate();

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return i;
    }

    @Override
    public List<Object> viewAll(Class clazz) throws Exception {
        PreparedStatement ps = null;
        List<Object> resultList = null;

        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (clazz.isAnnotationPresent(Entity.class)) {

            Annotation annotation = clazz.getAnnotation(Entity.class);

            if (annotation instanceof Entity) {
                query.append(((Entity) annotation).value()).append(" ORDER BY id ASC");
            }

        } else {
            query.append(clazz.getSimpleName()).append(" ORDER BY id ASC");
        }

        ps = connection.prepareStatement(query.toString());

        resultList = getResultList(ps.executeQuery(), clazz);

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultList;
    }

    @Override
    public Object viewById(E entity) throws Exception {
        PreparedStatement ps = null;
        List<Object> resultList = null;
        Object value = null;

        StringBuilder query = new StringBuilder("SELECT * FROM ");

        if (entity.getClass().isAnnotationPresent(Entity.class)) {

            Annotation annotation = entity.getClass().getAnnotation(Entity.class);

            if (annotation instanceof Entity) {
                query.append(((Entity) annotation).value());
            }

        } else {
            query.append(entity.getClass().getSimpleName());
        }

        query.append(" WHERE id = ");
        Field id = entity.getClass().getDeclaredField("id");
        id.setAccessible(true);
        query.append(id.get(entity));

        ps = connection.prepareStatement(query.toString());

        resultList = getResultList(ps.executeQuery(), entity.getClass());

        if (resultList != null) {
            value = resultList.get(0);
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return value;
    }

    private List<Object> getResultList(ResultSet rs, Class clazz) throws Exception {

        Field[] fields = clazz.getDeclaredFields();
        int i = 0;

        List<Object> resultList = new ArrayList<>();

        while (rs.next()) {
            Object obj = clazz.getConstructor().newInstance();
            for (Field field : fields) {
//                if(field.isAnnotationPresent(Column.class))
                field.setAccessible(true);
                field.set(obj, getObjectValue(rs, field));
            }

            resultList.add(obj);
        }

        return resultList;
    }

    private Object getObjectValue(ResultSet rs, Field field) throws Exception {
        Object o = null;

        if (field.isAnnotationPresent(Join.class)) {
            if (field.isAnnotationPresent(Column.class)) {
                Annotation annotation = field.getAnnotation(Column.class);
                o = rs.getInt(((Column) annotation).value());
            } else {
                o = rs.getInt(field.getType().getSimpleName());
            }

            if (o != null && o instanceof Integer) {
                Model m = (Model) field.getType().getConstructor().newInstance();
                m.setId((Integer) o);
                o = viewById((E) m);
            }

        } else {
            String fieldType = primitiveClassName.get(Class.forName(field.getType().getName())).getSimpleName();

            String rsMethodName = "get" + fieldType.substring(0, 1).toUpperCase() + fieldType.substring(1);
            Method rsMethod = rs.getClass().getMethod(rsMethodName, new Class[]{String.class});
            rsMethod.setAccessible(true);

            String columnName = null;
            
            if (field.isAnnotationPresent(Column.class)) {
                Annotation annotation = field.getAnnotation(Column.class);

                if (annotation instanceof Column) {
                    columnName = ((Column) annotation).value();
                }

            } else {
                columnName = field.getName();
            }

            o = rsMethod.invoke(rs, columnName);
        }

        return o;
    }

    @Override
    public List<Object> executeQuery(String query) throws Exception {
        String fromEntityNameToEnd = query.substring(query.toLowerCase().indexOf("from") + 5);
        String virsualEntityName = fromEntityNameToEnd.substring(0, fromEntityNameToEnd.indexOf(" "));
        String entityName = virsualEntityName.substring(0, 1).toUpperCase() + virsualEntityName.substring(1).toLowerCase();
        PreparedStatement ps = connection.prepareStatement(query);

        return getResultList(ps.executeQuery(), Class.forName("com.fcih.swing.hotel.model." + entityName));
    }
}
