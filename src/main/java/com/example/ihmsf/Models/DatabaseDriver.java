package com.example.ihmsf.Models;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Objects;

import com.example.ihmsf.Controllers.Doctor.AppointmentData;
import com.example.ihmsf.Controllers.LoginController;
import javafx.collections.ObservableList;

public class DatabaseDriver {
    private Connection connection;
    public static LoginController currentUser;

    public DatabaseDriver() {
        try{
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://mysql-2ff4c4f8-bedo2054-d043.c.aivencloud.com:24916/defaultdb?ssl-mode=REQUIRED",
                    "avnadmin",
                    "AVNS_pv0aowP5856X0xIw5-o"
            );
            System.out.println("Cloud Database connection established");
        }catch(SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    //    reciptionist section
    public ResultSet getRooms(){
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
//    public ObservableList<AppointmentData> appointmentGetData(int id) {
//        ObservableList<AppointmentData> result = null;
//        PreparedStatement statement;
//        try{
//            String query = "SELECT * FROM appointment WHERE date_delete IS NULL and doctor = ?";
//            statement = this.connection.prepareStatement(query);
//            statement.setString(1, String.valueOf(id));
//            result = prepare.executeQuery();
//
//            AppointmentData appData;
//
//            while (result.next()) {
////            Integer appointmentID, String name, String gender,
////            Long mobileNumber, String description, String diagnosis, String treatment, String address,
////            Date date, Date dateModify, Date dateDelete, String status, Date schedule
//
//                appData = new AppointmentData(result.getInt("appointment_id"),
//                        result.getString("name"), result.getString("gender"),
//                        result.getLong("mobile_number"), result.getString("description"),
//                        result.getString("diagnosis"), result.getString("treatment"),
//                        result.getString("address"), result.getDate("date"),
//                        result.getDate("date_modify"), result.getDate("date_delete"),
//                        result.getString("status"), result.getDate("schedule"));
//                // STORE ALL DATA
//                listData.add(appData);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return appData;
//    }
        public ResultSet getAvailableDoctors(String specialty){
        PreparedStatement statement;
        ResultSet resultSet = null;
        try{
            String query = "SELECT * FROM hospital.doctor WHERE department = ?";
            statement = this.connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, specialty);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("No available doctors in the database for the selected specialty.");
            } else {
                resultSet.beforeFirst(); // reset the cursor position
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR in retrieving availableDoctors (DatabaseDriver.java)");
        }
        return resultSet;
    }
    public ResultSet getTakeAttendance() {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hospital.attendance;");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in retrieving takeAttendance (DatabaseDriver.java)");
        }
        return resultSet;
    }
    public ResultSet getActivity(){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM hospital.doctor;");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR in retrieving activity");
        }
        return resultSet;
    }

    public void updateCheckInTime(String s, LocalDateTime checkInTime) {
        String query = "UPDATE hospital.attendance SET checkInTime = ? WHERE id = ?;";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(checkInTime));
            preparedStatement.setString(2, s);
            preparedStatement.executeUpdate();}
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR in updating checkInTime");
        }
    }
    public void updateCheckOutTime(String s, LocalDateTime checkOutTime) {
        String query = "UPDATE hospital.attendance SET checkOutTime = ? WHERE id = ?;";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(checkOutTime));
            preparedStatement.setString(2, s);
            preparedStatement.executeUpdate();}
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERROR in updating checkOutTime");
        }
    }


    //    Doctor Section
//    utility methods
    public boolean authenticateUser(String username, String password, String hospitalId) {
        String query = "SELECT * FROM hospital.authentication WHERE username = ? AND password = ? AND SUBSTRING(hospitalID, 1, 3) = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, hospitalId);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean userExists = resultSet.next();
            if (userExists) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
                System.out.println("ID: " + resultSet.getString("hospitalID"));
            }
            return userExists;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in authenticating user");
            return false;
        }
    }
    public String getUserType(String id) {
        String query = "SELECT type FROM hospital.authentication WHERE username = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in getting user type");
        }
        return null;
    }
    public String getUserName(String userId) {
        String current = Model.getInstance().getCurrentUserId();
        String currentType = getUserType(current);
        String query = "";
        String returned = "";
        if (Objects.equals(currentType, "Reciptionist")){
            query = "SELECT name FROM hospital.receptionist WHERE id = ?";
            try{
                PreparedStatement preparedStatement = this.connection.prepareStatement(query);
                preparedStatement.setString(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    returned = resultSet.getString("name");
                }
            } catch (SQLException e) {
                System.out.println("Error in getting UserName(DatabaseDriver.java)");
                throw new RuntimeException(e);
            }
        }
        else if (Objects.equals(currentType, "Doctor")){
            query = "SELECT name FROM hospital.doctor WHERE id = ?";
            try{
                PreparedStatement preparedStatement = this.connection.prepareStatement(query);
                preparedStatement.setString(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    returned = resultSet.getString("name");
                }
            } catch (SQLException e) {
                System.out.println("Error in getting UserName(DatabaseDriver.java)");
                throw new RuntimeException(e);
            }
        }
        return returned;
    }
    public String getHospitalName(String userId) {
        String query = "SELECT name FROM hospital.hospital WHERE id = (SELECT hospitalID FROM hospital.authentication WHERE username = ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR in getting hospital name");
        }
        return null;
    }

    public void saveAppointment(Appointment appointment) {
        String disableFKCheck = "SET foreign_key_checks = 0";
        String enableFKCheck = "SET foreign_key_checks = 1";
        String query = "INSERT INTO hospital.appoinment (date, Department, Status, TimeSlot, doctor3id, patientID) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            // Disable FK check
            PreparedStatement disableFKCheckStatement = this.connection.prepareStatement(disableFKCheck);
            disableFKCheckStatement.execute();

            // Insert appointment
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, appointment.getDateTime());
            preparedStatement.setString(2, appointment.getType());
            preparedStatement.setString(3, appointment.getStatus());
            preparedStatement.setString(4, appointment.getTimeSlot());
            preparedStatement.setString(5, appointment.getDoctorId());
            preparedStatement.setString(6, appointment.getPatientId());
            preparedStatement.executeUpdate();

            // Enable FK check
            PreparedStatement enableFKCheckStatement = this.connection.prepareStatement(enableFKCheck);
            enableFKCheckStatement.execute();
        } catch (SQLException e) {
            // Handle exception
        }
    }
    public Connection getConnection() {
        return connection;
    }
}