package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Doctor;
import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Models.TakeAttendance;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TakeAttendanceCellController implements Initializable {
    public Label doctorNameLabel;
    public Label doctorIDLabel;
    public Label datentimeLabel;
    public Button InButton;
    public Button OutButton;
    private final Doctor doctor;
    private final TakeAttendance takeAttendance;

    public TakeAttendanceCellController(Doctor doctor, TakeAttendance takeAttendance) {
        this.doctor = doctor;
        this.takeAttendance = takeAttendance;
    }

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    doctorNameLabel.setText(doctor.getDoctorName().get());
    doctorIDLabel.setText(doctor.getDoctorID().get());

    // Add null check for getCheckInTime()
    if (takeAttendance.getCheckInTime() != null) {
        datentimeLabel.setText(takeAttendance.getCheckInTime().toLocalDate().toString());
    } else {
        datentimeLabel.setText("No check-in time available");
    }

    InButton.setOnAction(event -> onInButtonAction());
    OutButton.setOnAction(event -> onOutButtonAction());
}

    private void onOutButtonAction() {
        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        // Update the check-out time in the TakeAttendance object
        takeAttendance.setCheckOutTime(now);

        // Update the check-out time in the database
        Model.getInstance().getDatabaseDriver().updateCheckOutTime(doctor.getDoctorID().get(), now);

        // Update the label
        datentimeLabel.setText(now.toLocalDate().toString());
    }

    private void onInButtonAction() {
        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        // Update the check-in time in the TakeAttendance object
        takeAttendance.setCheckInTime(now);

        // Update the check-in time in the database
        Model.getInstance().getDatabaseDriver().updateCheckInTime(doctor.getDoctorID().get(), now);

        // Update the label
        datentimeLabel.setText(now.toLocalDate().toString());
    }
}


