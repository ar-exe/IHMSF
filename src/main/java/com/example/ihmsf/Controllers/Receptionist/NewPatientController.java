package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Models.Patient;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewPatientController implements Initializable {
    public Button backButton;
    public TextField firstnameTextField;
    public TextField lastnameTextField;
    public TextField weightTextField;
    public TextField allergiesTextField;
    public ChoiceBox BloodTypeChoiceBox;
    public ChoiceBox genderChoiceBox;
    public DatePicker birthdatePicker;
    public TextField ssnTextField;
    public TextField phoneTextField;
    public TextField addressTextField;
    public Button registerButton;
    public Button printButton;
    public Label patientID;
    public Label patientName;
    public Label appointmentDate;
    public Label hospital;
    public Label bloodtype;
    public Label gender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerButton.setOnAction(event -> onRegisterButtonAction());
        BloodTypeChoiceBox.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        genderChoiceBox.getItems().addAll("Male","Female","Other");
        addListeners();
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Patients");
    }
    public void onRegisterButtonAction() {
    // Collect patient details from form fields
        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String patientFullName = firstName + " " + lastName;
    String weight = weightTextField.getText();
    String allergies = allergiesTextField.getText();
    String bloodType = BloodTypeChoiceBox.getValue().toString();
    String patientGender = genderChoiceBox.getValue().toString();
    String Birthdate = String.valueOf(birthdatePicker.getValue());
    String ssn = ssnTextField.getText();
    String phone = phoneTextField.getText();
    String address = addressTextField.getText();
    String currentUserId = Model.getInstance().getCurrentUserId();
String hospitalID = Model.getInstance().getDatabaseDriver().getHospitalIdForUser(currentUserId);
    // Create a new instance of the Patient class
    Patient newPatient = new Patient(patientFullName, patientGender, phone, address, bloodType, Birthdate, hospitalID, ssn);

    String generatedPatientId = Model.getInstance().getDatabaseDriver().savePatient(newPatient);
    newPatient.setId(generatedPatientId);

    // Use the DatabaseDriver class to save this new patient to the
    // Clear the form fields after successful registration
    clearFormFields();

    // Show a success message
    System.out.println("Patient registered successfully!");
        patientID.setText(generatedPatientId);
        patientName.setText(newPatient.getName());
        appointmentDate.setText(newPatient.getBirthDate()); // Set this to the actual appointment date when available
        hospital.setText(hospitalID); // You might want to fetch the hospital name using the ID
        bloodtype.setText(newPatient.getBloodType());
        gender.setText(newPatient.getGender());
}

private void clearFormFields() {
    firstnameTextField.clear();
    lastnameTextField.clear();
    weightTextField.clear();
    allergiesTextField.clear();
    BloodTypeChoiceBox.setValue(null);
    genderChoiceBox.setValue(null);
    birthdatePicker.setValue(null);
    ssnTextField.clear();
    phoneTextField.clear();
    addressTextField.clear();
}
//    private void onRegisterPatientButtonAction() {
//        Model.getInstance().getViewFactory().getRecipSelection().set("NewPatient");
//    }
}



