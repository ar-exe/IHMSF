package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.DatabaseDriver;
import com.example.ihmsf.Models.HistoryAttendance;
import com.example.ihmsf.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public Button viewButtton;
    public TextField inputTextField;
    public RadioButton doctorIDRadioButton;
    public RadioButton nameRadioButton;

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
        viewButtton.setOnAction(event -> onSearchButtonAction());

    }
private void onSearchButtonAction() {
    // Get the text from the inputTextField
    String searchText = inputTextField.getText();
    // Check which radio button is selected
    ResultSet resultSet;
    if (doctorIDRadioButton.isSelected()) {
        resultSet = Model.getInstance().getDatabaseDriver().searchAttendanceByDoctorId(searchText);
    } else if (nameRadioButton.isSelected()) {
        resultSet = Model.getInstance().getDatabaseDriver().searchAttendanceByName(searchText);
    } else {
        // Handle case where no radio button is selected
        return;
    }
    // Call the appropriate search method in DatabaseDriver
    ObservableList<HistoryAttendance> searchResults = FXCollections.observableArrayList();
   try {
    while (resultSet.next()) {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String date = resultSet.getString("date");

        // Retrieve check-in and check-out times
        Timestamp checkInTime = resultSet.getTimestamp("checkInTime");
        Timestamp checkOutTime = resultSet.getTimestamp("checkOutTime");

        // Convert Timestamp to LocalDateTime
        LocalDateTime checkIn = checkInTime != null ? checkInTime.toLocalDateTime() : null;
        LocalDateTime checkOut = checkOutTime != null ? checkOutTime.toLocalDateTime() : null;

        // Add to your searchResults
        searchResults.add(new HistoryAttendance(id, name, checkIn, checkOut));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
    // Update the TableView with the returned results
    attendTableView.setItems(searchResults);
}

    private void searchByDoctorId(String doctorId) {
        ObservableList<HistoryAttendance> filteredData = FXCollections.observableArrayList();
        for (HistoryAttendance attendance : attendanceData) {
            if (attendance.getId().toLowerCase().contains(doctorId)) {
                filteredData.add(attendance);
            }
        }
        attendTableView.setItems(filteredData);
    }

    private void searchByName(String name) {
        ObservableList<HistoryAttendance> filteredData = FXCollections.observableArrayList();
        for (HistoryAttendance attendance : attendanceData) {
            if (attendance.getName().toLowerCase().contains(name)) {
                filteredData.add(attendance);
            }
        }
        attendTableView.setItems(filteredData);
    }

    private void onBackButtonAction() {
        Model.getInstance().getViewFactory().getRecipSelection().set("Attendance");
    }

    private void loadDataFromDatabase() {
        DatabaseDriver dbDriver = new DatabaseDriver();
        ResultSet rs = dbDriver.getTakeAttendance();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rs.next()) {
                LocalDateTime checkIn = LocalDateTime.parse(rs.getString("checkInTime"), formatter);
                LocalDateTime checkOut = LocalDateTime.parse(rs.getString("checkOutTime"), formatter);
                HistoryAttendance attendance = new HistoryAttendance(
                        rs.getString("id"),
                        rs.getString("name"),
                        checkIn,
                        checkOut
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
//        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeInTableCol.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        timeOutTableCol.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
//        absReasonTableCol.setCellValueFactory(new PropertyValueFactory<>("absReason"));
    }
}





