package com.mgij.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app","root","");
        }catch(SQLException e){
            System.out.println("Connection fail");
            System.out.println(e);
        }
        return connection;
    }
}
