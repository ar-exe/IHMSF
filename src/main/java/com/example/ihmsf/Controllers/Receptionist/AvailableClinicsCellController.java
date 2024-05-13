package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Clinic;
import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AvailableClinicsCellController implements Initializable {
    public Label clinicIdLabel;
    public Label clinicSpecialityLabel;
    public Button clinicSelectButton;

    private final Clinic clinic;
    public AvailableClinicsCellController(Clinic clinic) {
        this.clinic = clinic;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clinicIdLabel.setText("C"+ clinic.getClinicID().get());
        clinicSpecialityLabel.setText(clinic.getClinicSpeciality().get());
        clinicSelectButton.setOnAction(e->{
            Model.getInstance().setSelectedClinic(clinic);
            System.out.println("Selected ClinicName: "+clinic.getClinicID().get());
            System.out.println("Selected ClinicSpeciality: "+clinic.getClinicSpeciality().get());
        });
    }
}
