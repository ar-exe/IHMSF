package com.example.ihmsf.Controllers.Receptionist;

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

    private final TakeAttendance takeAttendance;
    public TakeAttendanceCellController(TakeAttendance takeAttendance) {
        this.takeAttendance = takeAttendance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorNameLabel.setText(takeAttendance.getDoctorName().get());
        doctorIDLabel.setText(takeAttendance.getDoctorID().get());
        datentimeLabel.setText(String.valueOf(takeAttendance.getDate()));

        InButton.setOnAction(event -> onInButtonAction());
        OutButton.setOnAction(event -> onOutButtonAction());

    }

    private void onOutButtonAction() {
        LocalDateTime checkInTime = LocalDateTime.now();
        Model.getInstance().getDatabaseDriver().updateCheckInTime(takeAttendance.getDoctorID().get(), checkInTime);
    }

    private void onInButtonAction() {
        LocalDateTime checkOutTime = LocalDateTime.now();
        Model.getInstance().getDatabaseDriver().updateCheckOutTime(takeAttendance.getDoctorID().get(), checkOutTime);
    }
}
