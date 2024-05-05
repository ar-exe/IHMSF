package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReciptionistSidebarController implements Initializable {
    public Button dashboardButton;
    public Button appointmentButton;
    public Button patientsButton;
    public Button attendanceButton;
    public Button transferButton;
    public Button resourcesButton;
    public Button profileButton;
    public Button logoutButton;
    public Button reportButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        dashboardButton.setOnAction(event -> onDashboard());
        appointmentButton.setOnAction(event -> onAppointment());
        patientsButton.setOnAction(event -> onPatients());
        attendanceButton.setOnAction(event -> onAttendance());
        profileButton.setOnAction(event -> onProfile());
        logoutButton.setOnAction(event -> onLogout());
    }

    private void onProfile() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Profile");
    }

    private void onAppointment() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Appointment");
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Dashboard");
    }
    private void onPatients() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Patients");
    }
    private void onAttendance() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }
    private void onLogout(){
        Stage currentStage = (Stage) logoutButton.getScene().getWindow();
        Model.getInstance().clearUserData();
        Model.getInstance().getViewFactory().showLoginWindow();
        currentStage.close();
    }
}
