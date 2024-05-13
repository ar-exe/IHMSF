package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDateTime;

public class HistoryAttendance {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty date;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private SimpleStringProperty absReason;

    public HistoryAttendance(String id, String name, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
//        this.date = new SimpleStringProperty(date);
        this.timeIn = timeIn;
        this.timeOut = timeOut;
//        this.absReason = new SimpleStringProperty(absReason);
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

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getAbsReason() {
        return absReason.get();
    }

    public void setAbsReason(String absReason) {
        this.absReason.set(absReason);
    }
}



