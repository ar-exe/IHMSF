package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HistoryAttendanceController implements Initializable {
    public TextField employeeTextField;
    public RadioButton employeeIdRadioButton;
    public RadioButton nameRadioButton;
    public Button viewButtton;
    public TableView attendTableView;
    public TableColumn idTableCol;
    public TableColumn nameTablecol;
    public TableColumn dateTableCol;
    public TableColumn timeInTableCol;
    public TableColumn timeOutTableCol;
    public TableColumn absReasonTableCol;
    public Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }
}
