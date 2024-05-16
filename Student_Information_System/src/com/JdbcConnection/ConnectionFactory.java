package com.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//contains method that can open a connection and return connection object

public class ConnectionFactory {

    public static Connection getConnection() {
        Connection myConnection = null;
        String url = "jdbc:mysql://localhost:3306/sisdb";
        String username = "root";
        String password = "Tharunika*27";


        try {
            myConnection = DriverManager.getConnection(url, username, password );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return myConnection;
    }

}