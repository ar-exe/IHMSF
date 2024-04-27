package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
        addListeners();
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Patients");
    }

//    private void onRegisterPatientButtonAction() {
//        Model.getInstance().getViewFactory().getRecipSelection().set("NewPatient");
//    }
}
