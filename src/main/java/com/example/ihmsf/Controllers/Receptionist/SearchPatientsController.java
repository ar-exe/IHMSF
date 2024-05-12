package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Models.Patient;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchPatientsController implements Initializable {
    public RadioButton patientIdRadioButton;
    public RadioButton ssnRadioButton;
    public RadioButton nameRadioButton;
    public Label patientNameLabel;
    public TextField patientIdTextField;
    public Button searchButtton;
    public Button printButton;
    public Label patientID;
    public Label patientName;
    public Label patientBirthDate;
    public Label patientHospital;
    public Label bloodtype;
    public Label gender;
    public Label patientphone;
    public Label patientaddress;
    public Button transferButton;
    public ListView patientRecordListView;
    public ListView patientTestsListView;
    public Button backButton;

    private ToggleGroup searchToggleGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchToggleGroup = new ToggleGroup();
        patientIdRadioButton.setToggleGroup(searchToggleGroup);
        ssnRadioButton.setToggleGroup(searchToggleGroup);
        nameRadioButton.setToggleGroup(searchToggleGroup);
        searchButtton.setOnAction(event -> onSearchButtonAction());

        addListeners();
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Patients");
    }

    private void onSearchButtonAction() {
        RadioButton selectedRadioButton = (RadioButton) searchToggleGroup.getSelectedToggle();
        String searchText = patientIdTextField.getText();

        if (selectedRadioButton == patientIdRadioButton) {
            searchByPatientId(searchText);
        } else if (selectedRadioButton == ssnRadioButton) {
            searchBySSN(searchText);
        } else if (selectedRadioButton == nameRadioButton) {
            searchByName(searchText);
        }
    }

    private void searchByPatientId(String patientId) {
        // Implement your search logic here
        // For example:
        Patient patient = Model.getInstance().getDatabaseDriver().getPatientDetails(patientId);
        if (patient != null) {
            // Display patient details
            displayPatientData(patient);
        } else {
            // Show not found message
        }
    }
    // In SearchPatientsController.java
    private void searchBySSN(String ssn) {
     Patient patient = Model.getInstance().getDatabaseDriver().getPatientDetailsBySSN(ssn);
        if (patient != null) {
            displayPatientData(patient);
        // Display patient details
        } else {
        // Show not found message
     }
}

    private void searchByName(String name) {
         Patient patient = Model.getInstance().getDatabaseDriver().getPatientDetailsByName(name);
            if (patient != null) {
                displayPatientData(patient);
        // Display patient details
    } else {
        // Show not found message
    }
}
    public void displayPatientData(Patient patient) {
    // Set the labels with the patient data
    patientID.setText(patient.getId());
        System.out.println(patient.getId());
    patientName.setText(patient.getName());
        System.out.println(patient.getName());
    // Assuming you have these methods in your Patient class
    patientBirthDate.setText(patient.getBirthDate());
        System.out.println(patient.getBirthDate());
    patientHospital.setText(Model.getInstance().getDatabaseDriver().getHospitalNameForPatient(patient.getId()));
        System.out.println(Model.getInstance().getDatabaseDriver().getHospitalNameForPatient(patient.getId()));
    bloodtype.setText(patient.getBloodType());
        System.out.println(patient.getBloodType());
    gender.setText(patient.getGender());
        System.out.println(patient.getGender());
    patientphone.setText(patient.getPhone());
        System.out.println(patient.getPhone());
    patientaddress.setText(patient.getAddress());
        System.out.println(patient.getAddress());


    // Assuming you have a method to get the hospital name in your DatabaseDriver class
}


}

