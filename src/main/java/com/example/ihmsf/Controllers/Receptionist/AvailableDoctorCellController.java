package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Doctor;
import com.example.ihmsf.Models.Model;
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
        String doctorRole = Model.getInstance().getDatabaseDriver().getDoctorRole(doctor.getDoctorID().get());
        AvailableLabel.setText(doctorRole);
        selectButton.setOnAction(e->{
            Model.getInstance().setSelectedDoctor(doctor);
            System.out.println("Selected DoctorName: "+doctor.getDoctorName().get());
            System.out.println("Selected DoctorID: "+doctor.getDoctorID().get());
            System.out.println("Selected DoctorSpeciality: "+doctor.getDepartment().get());
            System.out.println("Selected DoctorAvailable: "+doctor.getAvailable().get());

        });
//        clinicSelectButton.setText("Select");
    }
}
