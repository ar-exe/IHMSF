package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.*;
import com.example.ihmsf.Views.AvailableClinicsCellFactory;
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
        Model.getInstance().setAvailableDoctors(specialityChoiceBox.getValue().toString());
        // Update the ListView
        availableDoctorsListView.setItems(Model.getInstance().getAvailableDoctors());
    });
    specialityChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        // Clear the previous clinics
        Model.getInstance().getAvailableClinics().clear();
        // Fetch the clinics for the selected specialty
        Model.getInstance().setAvailableClinics(specialityChoiceBox.getValue().toString());
        // Update the ListView
        availableClinicsListView.setItems(Model.getInstance().getAvailableClinics());
    });

    // Set the cell factory for the ListView
    availableDoctorsListView.setCellFactory(e -> new AvailableDoctorsCellFactory());
    availableClinicsListView.setCellFactory(e -> new AvailableClinicsCellFactory());
    bookButton.setOnAction(e -> bookAppointment());
}
public void bookAppointment() {
    Doctor selectedDoctor = Model.getInstance().getSelectedDoctor();
    Clinic selectedClinic = Model.getInstance().getSelectedClinic();
//    String appointmentIDText = appointmentID.getText();
    String dateText = datePicker.getValue().toString();
    String doctorNameText = String.valueOf(selectedDoctor.getDoctorName());
    String hospitalText = Model.getInstance().getDatabaseDriver().getHospitalNameForUser(Model.getInstance().getCurrentUserId());
    String speciality = specialityChoiceBox.getValue().toString();
    String clinicText = String.valueOf(selectedClinic.getClinicID());
//    String hospitalText = hospital.getText();
    String roomText = room.getText();
//    String doctorNameText = doctorName.getText();
    String patientID = patientIDInput.getText();
    String PatientName = Model.getInstance().getDatabaseDriver().getPatientName(patientID);
    LocalDate date = datePicker.getValue();
    String appointmentIDText = null;
    Appointment appointment = new Appointment(speciality, patientID, PatientName, appointmentIDText, date, doctorNameText, clinicText, hospitalText, roomText, selectedDoctor);
    appointmentIDText = Model.getInstance().getDatabaseDriver().saveAppointment(appointment);


    // Assuming you have text fields or other UI elements to get these values
    Patient patient = Model.getInstance().getDatabaseDriver().getPatientDetails(patientID);
    if (patient == null) {
        System.out.println("Patient not found!");
        return;
    }
    String patientName = patient.getName();
//    appointment = new Appointment(speciality, patientID, patientName, appointmentIDText, date, doctorNameText, clinicText, hospitalText, roomText, selectedDoctor);
    try {
        // Save the appointment to the database
        Model.getInstance().getDatabaseDriver().saveAppointment(appointment);

        // Show a success message
        System.out.println("Appointment booked successfully!");

        appointmentID.setText("");
        appointmentDate.setText("");
        doctorName.setText("");
        clinic.setText("");
        hospital.setText("");
        room.setText("");
        displayAppointmentData(appointment , appointmentIDText, hospitalText, doctorNameText, patientName);

        // Debug print statements
        System.out.println("Debug: Appointment details:");
        System.out.println("Speciality: " + appointment.getSpeciality());
        System.out.println("Patient ID: " + appointment.getPatientId());
        System.out.println("Patient Name: " + patientName);
        System.out.println("Appointment ID: " + appointmentIDText);
        System.out.println("Date: " + appointment.getDateTime());
        System.out.println("Doctor Name: " + doctorNameText);
        System.out.println("Clinic: " + appointment.getClinic());
        System.out.println("Hospital: " + hospitalText);
        System.out.println("Room: " + appointment.getRoom());


//        patientNameInput.clear();
//        appointmentIDInput.clear();
//        doctorNameInput.clear();
//        clinicInput.clear();
//        hospitalInput.clear();
//        roomInput.clear();
    } catch (Exception e) {
        // Show an error message
        System.out.println("Failed to book appointment: (AppointmentController.java) " + e.getMessage());
    }
}
public void displayAppointmentData(Appointment appointment, String appointmentIDText, String hospitalText, String doctorNameText, String patientNameText) {
    // Get patient details
    Patient patient = Model.getInstance().getDatabaseDriver().getPatientDetails(appointment.getPatientId());

    // Set the labels with the appointment data
    patientID.setText(appointment.getPatientId());
    patientName.setText(patient.getName());
    appointmentID.setText(appointmentIDText);
    appointmentDate.setText(appointment.getDateTime());
    doctorName.setText(appointment.getSelectedDoctor().getDoctorName().get()); // Retrieve the doctor name correctly
    hospital.setText(hospitalText);
//    clinic.setText(appointment.getClinic().isEmpty() ? "N/A" : appointment.getClinic()); // Handle empty clinic
//    room.setText(appointment.getRoom());
}
public void setAppointmentData(Appointment appointment, String appointmentIDText) {
    patientID.setText(appointment.getPatientId());
    patientName.setText(appointment.getPatientName());
    appointmentID.setText(appointmentIDText);
    appointmentDate.setText(appointment.getAppointmentDate().toString());
    doctorName.setText(appointment.getDoctorName());
    clinic.setText(appointment.getClinic());
    hospital.setText(appointment.getHospital());
    room.setText(appointment.getRoom());
}
//    private void initAvailableDoctors(){
//        if (Model.getInstance().getAvailableDoctors().isEmpty()){
//            Model.getInstance().setAvailableDoctors();
//        }
//    }
}






