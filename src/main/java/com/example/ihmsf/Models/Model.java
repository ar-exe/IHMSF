package com.example.ihmsf.Models;

import com.example.ihmsf.Views.ViewFactory;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
//    Resiptionist Section
    private final ObservableList<Rooms> rooms;

//    Doctor Section
    private Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.rooms = FXCollections.observableArrayList();
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
    public ObservableList<Rooms> getRooms(){ return rooms;}
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}
}
