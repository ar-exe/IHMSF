package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class mainAttendanceController implements Initializable {
    public Button takeAttendButton;
    public Button attendHistoryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        takeAttendButton.setOnAction(event -> onTakeAttendButtonAction());
        attendHistoryButton.setOnAction(event -> onAttendHistoryButtonAction());
    }
    private void onTakeAttendButtonAction() {
         Model.getInstance().getViewFactory().getRecipSelection().set("TakeAttendance");
    }
    private void onAttendHistoryButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("AttendanceHistory");
    }
}
