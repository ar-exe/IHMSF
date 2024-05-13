package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDateTime;

public class TakeAttendance {
    private final StringProperty doctorName;
    private final StringProperty doctorID;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    public TakeAttendance(String doctorName, String doctorID, LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        this.doctorName = new SimpleStringProperty(this, "Doctor Name", doctorName);
        this.doctorID = new SimpleStringProperty(this, "Doctor ID", doctorID);
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public StringProperty getDoctorName() {return this.doctorName;}
    public StringProperty getDoctorID() {return this.doctorID;}
    public LocalDateTime getCheckInTime() {return this.checkInTime;}
    public LocalDateTime getCheckOutTime() {return this.checkOutTime;}
    public void setCheckOutTime(LocalDateTime checkOutTime) {this.checkOutTime = checkOutTime;}
    public void setCheckInTime(LocalDateTime checkInTime) {this.checkInTime = checkInTime;}
}