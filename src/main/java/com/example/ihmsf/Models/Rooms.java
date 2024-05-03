package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rooms {
//    private final StringProperty room;
    private final StringProperty patientID;
    private final StringProperty roomID;
    private final StringProperty doctorName;
    private final StringProperty heartbeat;
    private final StringProperty state;
    public Rooms(String roomID, String patientID,String doctorID, String heartbeat, String state) {
        this.patientID = new SimpleStringProperty(this, "Patient ID" ,patientID);
        this.roomID = new SimpleStringProperty(this , "Room",roomID);
        this.doctorName = new SimpleStringProperty(this,"Doctor",doctorID);
        this.heartbeat = new SimpleStringProperty(this,"Heartbeat",heartbeat);
        this.state = new SimpleStringProperty(this,"State",state);
    }
//    @Override
//    public String toString() {
//        return "Room ID: " + roomID.get() +
//                ", Patient ID: " + patientID.get() +
//                ", State: " + state.get() +
//                ", Doctor Name: " + doctorName.get() +
//                ", Heartbeat: " + heartbeat.get();
//    }


    public StringProperty getPatientID() {return this.patientID;}
    public StringProperty getRoomID() {return this.roomID;}
    public StringProperty getDoctorName() {return this.doctorName;}
    public StringProperty getHeartbeat() {return this.heartbeat;}
    public StringProperty getState() {return this.state;}

}
