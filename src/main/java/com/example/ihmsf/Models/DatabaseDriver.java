package com.example.ihmsf.Models;

import java.sql.*;

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
    public ResultSet getRooms(int limit){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hospital.room;");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR in retrieving rooms");
        }
        return resultSet;
    }
//    Doctor Section
//    utility methods
}
