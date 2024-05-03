package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Activity {
    private final StringProperty doctorName;
    private final StringProperty status;

    public Activity(String doctorName, String status) {
        this.doctorName = new SimpleStringProperty(this, "Doctor Name", doctorName);
        this.status = new SimpleStringProperty(this, "Status", status);
    }

    public StringProperty getDoctorName() {return this.doctorName;}
    public StringProperty getStatus() {return this.status;}

}
