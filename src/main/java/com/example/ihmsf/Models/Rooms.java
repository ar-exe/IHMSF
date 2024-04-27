package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rooms {
//    private final StringProperty room;
    private final StringProperty patientID;
    private final StringProperty roomID;
    private final StringProperty doctorID;
    private final StringProperty heartbeat;
    private final StringProperty state;
    public Rooms(String room, String patientID, String roomID, String roomNumber,String doctorID, String heartbeat, String state) {
        this.patientID = new SimpleStringProperty(this, "Patient ID" ,patientID);
        this.roomID = new SimpleStringProperty(this , "Room",roomID);
        this.doctorID = new SimpleStringProperty(this,"Doctor",doctorID);
        this.heartbeat = new SimpleStringProperty(this,"Heartbeat",heartbeat);
        this.state = new SimpleStringProperty(this,"State",state);
    }
    public StringProperty getPatientID() {return this.patientID;}
    public StringProperty getRoomID() {return this.roomID;}
    public StringProperty getDoctorID() {return this.doctorID;}
    public StringProperty getHeartbeat() {return this.heartbeat;}
    public StringProperty getState() {return this.state;}

}
