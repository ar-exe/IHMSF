package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.DatabaseDriver;
import com.example.ihmsf.Models.HistoryAttendance;
import com.example.ihmsf.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HistoryAttendanceController implements Initializable {
    public TableView<HistoryAttendance> attendTableView;
    public TableColumn<HistoryAttendance, String> idTableCol;
    public TableColumn<HistoryAttendance, String> nameTablecol;
    public TableColumn<HistoryAttendance, String> dateTableCol;
    public TableColumn<HistoryAttendance, String> timeInTableCol;
    public TableColumn<HistoryAttendance, String> timeOutTableCol;
    public TableColumn<HistoryAttendance, String> absReasonTableCol;
    public Button backButton;

    private ObservableList<HistoryAttendance> attendanceData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        loadDataFromDatabase();
        bindTableViewToData();
        setupCellValueFactories();
    }
    private void addListeners(){
        backButton.setOnAction(event -> onBackButtonAction());

    }
    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }

    private void loadDataFromDatabase() {
        DatabaseDriver dbDriver = new DatabaseDriver();
        ResultSet rs = dbDriver.getTakeAttendance();
        try {
            while (rs.next()) {
                HistoryAttendance attendance = new HistoryAttendance(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("timeIn"),
                        rs.getString("timeOut"),
                        rs.getString("absReason")
                );
                attendanceData.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR accessing HistoryAttendance table (HistoryAttendanceController.java)");
        }
    }

    private void bindTableViewToData() {
        attendTableView.setItems(attendanceData);
    }

    private void setupCellValueFactories() {
        idTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTablecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeInTableCol.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        timeOutTableCol.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
        absReasonTableCol.setCellValueFactory(new PropertyValueFactory<>("absReason"));
    }
}