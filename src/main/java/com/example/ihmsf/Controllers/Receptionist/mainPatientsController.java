package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class mainPatientsController implements Initializable {
    public Button searchPatientsButton;
    public Button registerPatientButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        searchPatientsButton.setOnAction(event -> onSearchPatientsButtonAction());
        registerPatientButton.setOnAction(event -> onRegisterPatientButtonAction());
    }
    private void onSearchPatientsButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("SearchPatients");
    }

    private void onRegisterPatientButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("NewPatient");
    }
}
