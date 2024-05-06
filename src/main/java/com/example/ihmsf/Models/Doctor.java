package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor {
    private final StringProperty doctorID;
    private final StringProperty doctorName;
    private final StringProperty available;
    private final StringProperty department;


    public Doctor(String doctorID, String doctorName, String department, String available) {
        this.doctorID = new SimpleStringProperty(this, "Doctor ID", doctorID);
        this.doctorName = new SimpleStringProperty(this, "Doctor Name", doctorName);
        this.available = new SimpleStringProperty(this, "Available", available);
        this.department = new SimpleStringProperty(this, "Department", department);
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


}
