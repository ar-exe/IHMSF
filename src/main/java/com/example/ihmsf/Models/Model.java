package com.example.ihmsf.Models;

import com.example.ihmsf.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private String currentUserId;
    private String currentUserName;
//    Resiptionist Section
    private final ObservableList<Rooms> rooms;
    private final ObservableList<Activity> activity;
    private final ObservableList<TakeAttendance> takeAttendance;
    private final ObservableList<Doctor> availableDoctors;
    private final ObservableList<Clinic> availableClinics;

//    Doctor Section
    private Doctor selectedDoctor;
    private Clinic selectedClinic;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.rooms = FXCollections.observableArrayList();
        this.activity = FXCollections.observableArrayList();
        this.takeAttendance = FXCollections.observableArrayList();
        this.availableDoctors = FXCollections.observableArrayList();
        this.availableClinics = FXCollections.observableArrayList();
    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
    public void setRooms(){prepareRooms(this.rooms,4);}
    private void prepareRooms(ObservableList<Rooms> rooms, int limit){
        ResultSet resultSet = databaseDriver.getRooms();

        try{
            while (resultSet.next()){
                String roomID = resultSet.getString("id");
                String patientID = resultSet.getString("patientID");
                String state = resultSet.getString("state");
                String doctorName = resultSet.getString("doctorName");
                String heartbeat = resultSet.getString("heartbeat");
                rooms.add(new Rooms(roomID,patientID,doctorName,heartbeat,state));
//                for (Rooms rooms1 : rooms) {
//                    System.out.println(rooms1); // Calls the overridden toString() method
//                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error in getting rooms");
        }
    }
    public void setAvailableDoctors(String speciality){prepareAvailableDoctors(this.availableDoctors,4,speciality);}
    private void prepareAvailableDoctors(ObservableList<Doctor> availableDoctors, int limit, String speciality){
    ResultSet resultSet = databaseDriver.getAvailableDoctors(speciality);

    try{
        if (!resultSet.next()) {
            System.out.println("No available doctors in the ResultSet.");
        } else {
            resultSet.beforeFirst(); // reset the cursor position
            while (resultSet.next()){
                String doctorID = resultSet.getString("id");
                String doctorName = resultSet.getString("name");
                String department = resultSet.getString("department");
                String availability = resultSet.getString("availability");
                String role = databaseDriver.getDoctorRole(doctorID);
                availableDoctors.add(new Doctor(doctorID, doctorName, department, availability, role));
            }
        }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("Error in getting available doctors(Model.java)");
    }
}
    public void setAvailableClinics(String speciality){prepareAvailableClinics(this.availableClinics,4,speciality);}
    public void prepareAvailableClinics(ObservableList<Clinic> availableClinics, int limit, String speciality) {
        ResultSet resultSet = databaseDriver.getAvailableClinics(speciality);

        try{
            if (!resultSet.next()) {
                System.out.println("No available doctors in the ResultSet.");
            } else {
                resultSet.beforeFirst(); // reset the cursor position
                while (resultSet.next()){
                    String ClinicID = resultSet.getString("id");
//                    String doctorName = resultSet.getString("name");
//                    String department = resultSet.getString("department");
//                    String availability = resultSet.getString("availability");
                    String Speciality = resultSet.getString("speciality");
                    String role = databaseDriver.getDoctorRole(ClinicID);
                    availableClinics.add(new Clinic(ClinicID, Speciality));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error in getting available Clinics(Model.java)");
        }
}
public void setTakeAttendance() {
    // Retrieve the ResultSet from the DatabaseDriver
    ResultSet resultSet = databaseDriver.getTakeAttendance();

    try {
        // Iterate over the ResultSet
        while (resultSet.next()) {
            // Retrieve the necessary fields from the ResultSet
            String doctorName = resultSet.getString("name");
            String doctorID = resultSet.getString("id");

            Timestamp checkInTimestamp = resultSet.getTimestamp("checkInTime");
            LocalDateTime checkInTime = checkInTimestamp != null ? checkInTimestamp.toLocalDateTime() : null;

            Timestamp checkOutTimestamp = resultSet.getTimestamp("checkOutTime");
            LocalDateTime checkOutTime = checkOutTimestamp != null ? checkOutTimestamp.toLocalDateTime() : null;

            // Create a new TakeAttendance object
            TakeAttendance takeAttendance = new TakeAttendance(doctorName, doctorID, checkInTime, checkOutTime);

            // Add the TakeAttendance object to the takeAttendance ObservableList
            this.takeAttendance.add(takeAttendance);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ERROR in setting takeAttendance (Model.java)");
    }
}
//    public void setTakeAttendance(){prepareTakeAttendance(this.takeAttendance);}
//public void prepareTakeAttendance(ObservableList<TakeAttendance> takeAttendance) {
//    System.out.println("Preparing take attendance");
//    String tableName = "attendance_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//    databaseDriver.createDailyAttendanceTable(LocalDate.now());
//    databaseDriver.populateDailyAttendanceTable(tableName);
//    ResultSet resultSet = databaseDriver.getDailyAttendance(tableName);
//    try {
//        while (resultSet.next()) {
//            String doctorId = resultSet.getString("doctor_id");
//            Timestamp checkInTimestamp = resultSet.getTimestamp("check_in_time");
//            LocalDateTime checkInTime = checkInTimestamp != null ? checkInTimestamp.toLocalDateTime() : null;
//            Timestamp checkOutTimestamp = resultSet.getTimestamp("check_out_time");
//            LocalDateTime checkOutTime = checkOutTimestamp != null ? checkOutTimestamp.toLocalDateTime() : null;
//            String doctorName = databaseDriver.getDoctorName(doctorId);
//            TakeAttendance attendance = new TakeAttendance(doctorName, doctorId, checkInTime, checkOutTime);
//            takeAttendance.add(attendance);
//        }
//        for(TakeAttendance attendance : takeAttendance) {
//            System.out.println(attendance.getDoctorName().get() + ", " + attendance.getDoctorID().get() + ", " + attendance.getCheckInTime() + ", " + attendance.getCheckOutTime());
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        System.out.println("ERROR in preparing take attendance");
//    }
//}
    public void setActivity(){prepareActivity(this.activity,4);}
    private void prepareActivity(ObservableList<Activity> activity, int limit){
        ResultSet resultSet = databaseDriver.getActivity();

        try{
            while (resultSet.next()){
                String doctorName = resultSet.getString("doctorName");
                String status = resultSet.getString("status");
                activity.add(new Activity(doctorName,status));
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error in getting activity");
        }
    }
    public ObservableList<Activity> getActivity(){return activity;}
    public ObservableList<Rooms> getRooms(){ return rooms;}
    public ObservableList<TakeAttendance> getTakeAttendance(){return takeAttendance;}
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}
    public String getCurrentUserId() {return currentUserId;}
    public ObservableList<Doctor> getAvailableDoctors() {return availableDoctors;}
    public String getCurrentUserName(){return currentUserName;}
    public void setCurrentUserId(String currentUserId) {this.currentUserId = currentUserId;}
    public void clearUserData(){currentUserId = null;}
    public Doctor getSelectedDoctor(){return selectedDoctor;}
    public void setSelectedDoctor(Doctor selectedDoctor){this.selectedDoctor = selectedDoctor;}
    public void setCurrentUserName(String currentUserName) {this.currentUserName = currentUserName;}

    public ObservableList<Clinic> getAvailableClinics() {return availableClinics;}

    public void setSelectedClinic(Clinic selectedClinic) {
        this.selectedClinic = selectedClinic;
    }
    public Clinic getSelectedClinic() {
        return selectedClinic;
    }
}







// DatabaseDriver.java


// Model.java

