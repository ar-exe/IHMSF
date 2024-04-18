package com.example.ihmsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC {

    public MyJDBC() {
        try {
            // Attempt to establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "MYSQL12345678");
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            // Handle database connection errors
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Add methods to perform database operations using the established connection
}
