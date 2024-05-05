package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Doctor;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class AvailableDoctorCellController implements Initializable {
    public Label doctorNameLabel;
    public Label AvailableLabel;
    public Button selectButton;

    private final Doctor doctor;
    public AvailableDoctorCellController(Doctor doctor) {
        this.doctor = doctor;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorNameLabel.setText(doctor.getDoctorName().get());
        AvailableLabel.setText(doctor.getAvailable().get());
//        selectButton.setText("Select");
    }
}
