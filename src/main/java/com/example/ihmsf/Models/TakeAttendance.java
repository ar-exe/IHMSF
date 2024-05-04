package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TakeAttendance {
    private final StringProperty doctorName;
    private final StringProperty doctorID;
    private final LocalDateTime date;
    private Button InButton;
    private Button OutButton;
    public TakeAttendance(String doctorName, String doctorID, LocalDateTime date) {
        this.doctorName = new SimpleStringProperty(this, "Doctor Name", doctorName);
        this.doctorID = new SimpleStringProperty(this, "Doctor ID", doctorID);
        this.date = date;
    }
    public StringProperty getDoctorName() {return this.doctorName;}
    public StringProperty getDoctorID() {return this.doctorID;}
    public LocalDateTime getDate() {return this.date;}

}
