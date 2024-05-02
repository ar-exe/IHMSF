package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
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
    public Label appointmentDate;
    public Label hospital;
    public Label bloodtype;
    public Label gender;
    public Label patientphone;
    public Label patientaddress;
    public Button transferButton;
    public ListView patientRecordListView;
    public ListView patientTestsListView;
    public Button backButton;

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
}
