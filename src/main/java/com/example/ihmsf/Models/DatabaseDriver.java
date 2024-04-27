package com.example.ihmsf.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {
    private Connection connection;

    public DatabaseDriver() {
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "MYSQL12345678");
            System.out.println("Database connection established");
        }catch(SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

//    reciptionist section

//    Doctor Section
//    utility methods
}
