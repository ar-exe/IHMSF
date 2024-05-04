package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;

public class HistoryAttendance {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty date;
    private SimpleStringProperty timeIn;
    private SimpleStringProperty timeOut;
    private SimpleStringProperty absReason;

    public HistoryAttendance(String id, String name, String date, String timeIn, String timeOut, String absReason) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.timeIn = new SimpleStringProperty(timeIn);
        this.timeOut = new SimpleStringProperty(timeOut);
        this.absReason = new SimpleStringProperty(absReason);
    }

    // getters and setters
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTimeIn() {
        return timeIn.get();
    }

    public void setTimeIn(String timeIn) {
        this.timeIn.set(timeIn);
    }

    public String getTimeOut() {
        return timeOut.get();
    }

    public void setTimeOut(String timeOut) {
        this.timeOut.set(timeOut);
    }

    public String getAbsReason() {
        return absReason.get();
    }

    public void setAbsReason(String absReason) {
        this.absReason.set(absReason);
    }
}