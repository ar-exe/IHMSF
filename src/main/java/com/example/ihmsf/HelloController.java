package com.example.ihmsf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class HelloController {

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private ChoiceBox<String> BloodTypeChoiceBox;

    @FXML
    private ComboBox<String> SpecComboBox;
    private Connection connection;

    @FXML
    private Label patientNameLabel;
    @FXML
    private TextField patientIdTextField;
    @FXML
    private RadioButton patientIdRadioButton, nameRadioButton, ssnRadioButton;
    private ToggleGroup searchToggleGroup;
    
    public HelloController() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "MYSQL12345678");
            System.out.println("Database connection established successfully.");
             // Initialize the ToggleGroup and add the radio buttons to it
            // searchToggleGroup = new ToggleGroup();
            // patientIdRadioButton.setToggleGroup(searchToggleGroup);
            // nameRadioButton.setToggleGroup(searchToggleGroup);
            // ssnRadioButton.setToggleGroup(searchToggleGroup);
        } catch (SQLException e) {
            // Handle database connection errors
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {
        // Initialize the gender ChoiceBox with default items
        ObservableList<String> genderOptions = FXCollections.observableArrayList("Male", "Female", "Other");
        genderChoiceBox.setItems(genderOptions);
    
        // Initialize the another ChoiceBox with default items
        ObservableList<String> BloodTypeOptions = FXCollections.observableArrayList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        BloodTypeChoiceBox.setItems(BloodTypeOptions);
    
        // Initialize the ComboBox with default items
        ObservableList<String> SpecOptions = FXCollections.observableArrayList("Internal Medicine", "Surgery", "Pediatrics", "Obstetrics and Gynecology", "Emergency Medicine", "Radiology", "Oncology", "Cardiology", "Neurology", "Orthopedics", "Psychiatry");
        SpecComboBox.setItems(SpecOptions);
        
        // Set the toggle group for the radio buttons
        searchToggleGroup = new ToggleGroup();
        patientIdRadioButton.setToggleGroup(searchToggleGroup);
        nameRadioButton.setToggleGroup(searchToggleGroup);
        ssnRadioButton.setToggleGroup(searchToggleGroup);
    }
    
    @FXML
    private void searchByIdButtonClicked() {
    try {
        // Retrieve PatientID entered by the user
        int patientId = Integer.parseInt(patientIdTextField.getText());

        // Prepare SQL statement
        String sql = "SELECT * FROM patient WHERE idpatient = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, patientId);

        // Execute SQL query
        ResultSet resultSet = statement.executeQuery();

        // Check if a row was found
        if (resultSet.next()) {
            // Retrieve data from the ResultSet
            String firstName = resultSet.getString("name");


            // Update Labels with retrieved data
            patientNameLabel.setText(firstName);

        } else {
            // No matching patient found
            // You can display an error message or clear the Labels
            patientNameLabel.setText("Patient not found");

        }
    } catch (SQLException e) {
        // Handle database query errors
        System.err.println("Error executing SQL statement: " + e.getMessage());
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Handle invalid input for PatientID (e.g., non-numeric input)
        System.err.println("Invalid input for PatientID: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void searchBySSnButtonClicked() {
    try {
        // Retrieve PatientID entered by the user
        int patientId = Integer.parseInt(patientIdTextField.getText());

        // Prepare SQL statement
        String sql = "SELECT * FROM patient WHERE ssn = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, patientId);

        // Execute SQL query
        ResultSet resultSet = statement.executeQuery();

        // Check if a row was found
        if (resultSet.next()) {
            // Retrieve data from the ResultSet
            String firstName = resultSet.getString("name");


            // Update Labels with retrieved data
            patientNameLabel.setText(firstName);

        } else {
            // No matching patient found
            // You can display an error message or clear the Labels
            patientNameLabel.setText("Patient not found");

        }
    } catch (SQLException e) {
        // Handle database query errors
        System.err.println("Error executing SQL statement: " + e.getMessage());
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Handle invalid input for PatientID (e.g., non-numeric input)
        System.err.println("Invalid input for PatientID: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void searchByNameButtonClicked() {
    try {
        // Retrieve PatientID entered by the user
        String patientId = patientIdTextField.getText();

        // Prepare SQL statement
        String sql = "SELECT * FROM patient WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, String.valueOf(patientId));

        // Execute SQL query
        ResultSet resultSet = statement.executeQuery();

        // Check if a row was found
        if (resultSet.next()) {
            // Retrieve data from the ResultSet
            String firstName = resultSet.getString("name");


            // Update Labels with retrieved data
            patientNameLabel.setText(firstName);

        } else {
            // No matching patient found
            // You can display an error message or clear the Labels
            patientNameLabel.setText("Patient not found");

        }
    } catch (SQLException e) {
        // Handle database query errors
        System.err.println("Error executing SQL statement: " + e.getMessage());
        e.printStackTrace();
    } catch (NumberFormatException e) {
        // Handle invalid input for PatientID (e.g., non-numeric input)
        System.err.println("Invalid input for PatientID: " + e.getMessage());
        e.printStackTrace();
    }
}
    @FXML
    private void handleSearchButtonAction() {
        RadioButton selectedRadioButton = (RadioButton) searchToggleGroup.getSelectedToggle();
        String searchText = patientIdTextField.getText();

        if (selectedRadioButton == patientIdRadioButton) {
        // Perform search by patient ID
            searchByIdButtonClicked();
        } else if (selectedRadioButton == nameRadioButton) {
        // Perform search by name
            searchByNameButtonClicked();
        } else if (selectedRadioButton == ssnRadioButton) {
        // Perform search by SSN
            searchBySSnButtonClicked();
    }
}

}
