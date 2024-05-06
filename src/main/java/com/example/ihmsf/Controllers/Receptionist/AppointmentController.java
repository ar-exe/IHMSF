package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Appointment;
import com.example.ihmsf.Models.Doctor;
import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Views.AvailableDoctorsCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
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
    specialityChoiceBox.getItems().add("General");
    specialityChoiceBox.getItems().add("Dermatology");
    specialityChoiceBox.getItems().add("Cardiology");
    specialityChoiceBox.getItems().add("Neurology");
    specialityChoiceBox.getItems().add("Orthopedics");
    specialityChoiceBox.getItems().add("Pediatrics");
    // Set a default value
    specialityChoiceBox.setValue("General");

    // Add a listener to the specialityChoiceBox
    specialityChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        // Clear the previous doctors
        Model.getInstance().getAvailableDoctors().clear();
        // Fetch the doctors for the selected specialty
        Model.getInstance().setAvailableDoctors(newValue.toString());
        // Update the ListView
        availableDoctorsListView.setItems(Model.getInstance().getAvailableDoctors());
    });

    // Set the cell factory for the ListView
    availableDoctorsListView.setCellFactory(e -> new AvailableDoctorsCellFactory());
    bookButton.setOnAction(e -> bookAppointment());
}
public void bookAppointment() {
    String speciality = specialityChoiceBox.getValue().toString();
    String patientID = patientIDInput.getText();
    LocalDate date = datePicker.getValue();
    Doctor selectedDoctor = Model.getInstance().getSelectedDoctor();

    Appointment appointment = new Appointment(speciality, patientID, date, selectedDoctor);

    try {
        // Save the appointment to the database
        Model.getInstance().getDatabaseDriver().saveAppointment(appointment);

        // Show a success message
        System.out.println("Appointment booked successfully!");

        // Clear the form inputs
        specialityChoiceBox.setValue(null);
        patientIDInput.clear();
        datePicker.setValue(null);
        availableDoctorsListView.getSelectionModel().clearSelection();
    } catch (Exception e) {
        // Show an error message
        System.out.println("Failed to book appointment: (AppointmentController.java) " + e.getMessage());
    }
}
//    private void initAvailableDoctors(){
//        if (Model.getInstance().getAvailableDoctors().isEmpty()){
//            Model.getInstance().setAvailableDoctors();
//        }
//    }
}
