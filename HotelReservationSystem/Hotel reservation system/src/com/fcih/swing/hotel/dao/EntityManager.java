package com.fcih.swing.hotel.dao;

import java.util.List;

public interface EntityManager<E> {

    void add(E entity) throws Exception;

    int update(E entity) throws Exception;

    int delete(E entity) throws Exception;
    
    List<Object> viewAll(Class clazz) throws Exception;
    
    Object viewById(E entity) throws Exception;
    
    List<Object> executeQuery(String query) throws Exception;
}
