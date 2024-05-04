package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Views.takeAttendanceCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TakeAttendanceController implements Initializable{
    public Button backButton;
    public ListView attendanceListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        initTakeAttendance();
        attendanceListView.setItems(Model.getInstance().getTakeAttendance());
        attendanceListView.setCellFactory(e -> new takeAttendanceCellFactory());
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }
    private void initTakeAttendance(){
        if (Model.getInstance().getTakeAttendance().isEmpty()){
            Model.getInstance().setTakeAttendance();
        }
    }
}
