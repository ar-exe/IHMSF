package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Doctor;
import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Models.TakeAttendance;
import com.example.ihmsf.Views.takeAttendanceCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TakeAttendanceController implements Initializable{
    public Button backButton;
    public ListView<Doctor> attendanceListView;

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    System.out.println("TakeAttendanceController");
    addListeners();
    initTakeAttendance();

    // Get all doctors from the database
    ResultSet resultSet = Model.getInstance().getDatabaseDriver().getAllDoctors();
    ObservableList<Doctor> doctors = FXCollections.observableArrayList();

    try {
        while (resultSet.next()) {
            String doctorID = resultSet.getString("id");
            String doctorName = resultSet.getString("name");
            String department = resultSet.getString("department");
            String availability = resultSet.getString("availability");
            String role = resultSet.getString("role");
            doctors.add(new Doctor(doctorID, doctorName, department, availability, role));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ERROR in retrieving all doctors (TakeAttendanceController.java)");
    }

    System.out.println("Number of doctors: " + doctors.size());
    attendanceListView.setItems(doctors);
    attendanceListView.setCellFactory(e -> new takeAttendanceCellFactory());
}
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }
    private void initTakeAttendance(){
        if (Model.getInstance().getTakeAttendance().isEmpty()){
            Model.getInstance().setTakeAttendance();
        }
    }
}
