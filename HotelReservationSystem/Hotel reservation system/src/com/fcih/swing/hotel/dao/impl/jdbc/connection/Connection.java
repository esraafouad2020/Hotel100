package com.fcih.swing.hotel.dao.impl.jdbc.connection;

import java.sql.SQLException;

public interface Connection {
    public abstract java.sql.Connection getConnection(String url, String databasName, String password) throws ClassNotFoundException, SQLException ; 
}
