package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Views.AvailableDoctorsCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {
    public TextField patientIDInput;
    public ChoiceBox specialityChoiceBox;
    public ListView availableDoctorsListView;
    public DatePicker datePicker;
    public ListView availableClinicsListView;
    public ListView availableRoomsListView;
    public Button bookButton;
    public Button printButton;
    public Label patientID;
    public Label patientName;
    public Label appointmentID;
    public Label appointmentDate;
    public Label doctorName;
    public Label clinic;
    public Label hospital;
    public Label room;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAvailableDoctors();
        availableDoctorsListView.setItems(Model.getInstance().getAvailableDoctors());
        System.out.println("Available doctors: " + Model.getInstance().getAvailableDoctors()); // print statement
        availableDoctorsListView.setCellFactory(e -> new AvailableDoctorsCellFactory());
    }
    private void initAvailableDoctors(){
        if (Model.getInstance().getAvailableDoctors().isEmpty()){
            Model.getInstance().setAvailableDoctors();
        }
    }
}
