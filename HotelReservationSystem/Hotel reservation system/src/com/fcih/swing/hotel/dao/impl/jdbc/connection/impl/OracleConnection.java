package com.fcih.swing.hotel.dao.impl.jdbc.connection.impl;

import com.fcih.swing.hotel.dao.impl.jdbc.connection.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class OracleConnection implements Connection{

    private static java.sql.Connection connection;
    private static OracleConnection orclConnection;
    
    private OracleConnection() {
    }

    @Override
    public java.sql.Connection getConnection(String url, String databasName, String password) throws ClassNotFoundException, SQLException {
        if (connection == null) {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection(url, databasName, password);
        }

        return connection;
    }
    
    public static OracleConnection getOracleConnection() {
        if (orclConnection == null) {
            orclConnection = new OracleConnection();
        }
        return orclConnection;
    }
}
