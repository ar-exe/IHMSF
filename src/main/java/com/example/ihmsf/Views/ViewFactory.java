package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.NewPatientController;
import com.example.ihmsf.Controllers.Receptionist.ReciptionistController;
import com.example.ihmsf.Controllers.Receptionist.SearchPatientsController;
import com.example.ihmsf.Controllers.Receptionist.mainPatientsController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    //Reciptionist Dashboard View
    private final StringProperty RecipSelection;
    private AnchorPane dashboardView;
    //Reciptionist Appointment View
    private AnchorPane appointmentView;
    private AnchorPane newPatientView;
    private AnchorPane searchPatientView;
    private AnchorPane patientsView;
    private AnchorPane mainAttendanceView;
    private AnchorPane takeAttendanceView;
    private AnchorPane attendanceHistoryView;
    private AnchorPane profileView;
    public ViewFactory() {
        this.RecipSelection = new SimpleStringProperty();
    }
    public StringProperty getRecipSelection() {
        return RecipSelection;
    }
    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
    public AnchorPane getAppointmentView() {
        if (appointmentView == null) {
            try{
                appointmentView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Appointment.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return appointmentView;
    }    public AnchorPane getPatientsView() {
        if (patientsView == null) {
            try{
                patientsView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/mainPatients.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return patientsView;
    }public AnchorPane getNewPatientView() {
        if (newPatientView == null) {
            try{
                newPatientView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/newpatient.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return newPatientView;
    }public AnchorPane getSearchPatientView() {
        if (searchPatientView == null) {
            try{
                searchPatientView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/searchforpatient.fxml")).load();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return searchPatientView;
    }
    public AnchorPane getAttendanceView() {
        if (mainAttendanceView == null) {
            try{
                mainAttendanceView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/mainAttendance.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR Loading Attendance View");
            }
        }
        return mainAttendanceView;
    }
    public AnchorPane getTakeAttendanceView() {
        if (takeAttendanceView == null) {
            try{
                takeAttendanceView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/TakeAttendance.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR Loading Take Attendance View");
            }
        }
        return takeAttendanceView;
    }
    public AnchorPane getAttendanceHistoryView() {
        if (attendanceHistoryView == null) {
            try{
                attendanceHistoryView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/HistoryAttendance.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR Loading Attendance History View");
            }
        }
        return attendanceHistoryView;
    }
    public AnchorPane getProfileView(){
        if (profileView == null) {
            try{
                profileView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Profile.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ERROR Loading Profile View");
            }
        }
        return profileView;
    }
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));

        createStage(loader);
    }
    public void showReciptionistDashboard(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Reciptionist.fxml"));
        ReciptionistController reciptionistController = new ReciptionistController();
        loader.setController(reciptionistController);
        createStage(loader);
    }
    public void showReciptionistPatients(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/mainPatients.fxml"));
        mainPatientsController mainpatientsController = new mainPatientsController();
        loader.setController(mainpatientsController);
        createStage(loader);
    }
    public void showNewPatient(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/NewPatient.fxml"));
        NewPatientController newPatientController = new NewPatientController();
        loader.setController(newPatientController);
        createStage(loader);
    }    public void showSearchPatient(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/searchPatient.fxml"));
        SearchPatientsController searchPatientsController = new SearchPatientsController();
        loader.setController(searchPatientsController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        stage.setTitle("IHMS");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}