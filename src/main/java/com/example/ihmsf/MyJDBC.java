package com.example.ihmsf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital01", "root", "MYSQL12345678");

    public MyJDBC() throws SQLException {
    }
}
