package com.fcih.swing.hotel.dao.factory;

import com.fcih.swing.hotel.dao.EntityManager;
import com.fcih.swing.hotel.dao.impl.jdbc.OracleEntityManager;
import java.sql.SQLException;

public class EntityFactory {
    public static EntityManager getEntityManager() throws ClassNotFoundException, SQLException {
        return new OracleEntityManager();
    }
}
