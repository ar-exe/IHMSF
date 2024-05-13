package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Doctor {
    private final StringProperty doctorID;
    private final StringProperty doctorName;
    private final StringProperty available;
    private final StringProperty department;
    private final StringProperty role;


    public Doctor(String doctorID, String doctorName, String department, String available,String Role) {
        this.doctorID = new SimpleStringProperty(this, "Doctor ID", doctorID);
        this.doctorName = new SimpleStringProperty(this, "Doctor Name", doctorName);
        this.available = new SimpleStringProperty(this, "Available", available);
        this.department = new SimpleStringProperty(this, "Department", department);
        this.role = new SimpleStringProperty(this, "Role", Role);
    }

    public StringProperty getDoctorID() {
        return this.doctorID;
    }
    public StringProperty getDoctorName() {
//        System.out.println("Doctor Name: (Doctor.java) " + this.doctorName);
        return this.doctorName;
    }
    public StringProperty getAvailable() {
//        System.out.println("Available: (Doctor.java) " + this.available);
        return this.available;
    }
    public StringProperty getDepartment() {
        return this.department;
    }


    public StringProperty getRole() {
        return this.role;
    }
}
