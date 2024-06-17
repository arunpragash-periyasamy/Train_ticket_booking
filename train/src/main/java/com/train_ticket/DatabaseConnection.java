package com.train_ticket;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/train_booking";
    private static final String USER = "train_ticket"; // Change this to your database username
    private static final String PASSWORD = "train_ticket"; // Change this to your database password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
