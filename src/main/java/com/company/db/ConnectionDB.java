package com.company.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if(connection != null){
                connection.close();
                connection = null;
                System.out.println("INFO: Connection CLOSE");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
