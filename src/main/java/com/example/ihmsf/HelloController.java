package com.example.ihmsf;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class HelloController {

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private ChoiceBox<String> BloodTypeChoiceBox;

    @FXML
    private ComboBox<String> SpecComboBox;


    @FXML
    public void initialize() {
        // Initialize the gender ChoiceBox with default items
        ObservableList<String> genderOptions = FXCollections.observableArrayList("Male", "Female", "Other");
        genderChoiceBox.setItems(genderOptions);

        // Initialize the another ChoiceBox with default items
        ObservableList<String> BloodTypeOptions = FXCollections.observableArrayList("A+", "A-", "B+","B-","AB+","AB-","O+","O-");
        BloodTypeChoiceBox.setItems(BloodTypeOptions);

        // Initialize the ComboBox with default items
        ObservableList<String> SpecOptions = FXCollections.observableArrayList("Internal Medicine", "Surgery", "Pediatrics","Obstetrics and Gynecology","Emergency Medicine","Radiology","Oncology","Cardiology","Neurology","Orthopedics","Psychiatry");
        SpecComboBox.setItems(SpecOptions);
    }
}
