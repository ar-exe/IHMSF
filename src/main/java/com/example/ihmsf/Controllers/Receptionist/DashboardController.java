package com.example.ihmsf.Controllers.Receptionist;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Label hospital_name;
    public Label current_patients;
    public Label rooms;
    public Label active_doctors;
    public Label appointments;
    public ListView rooms_listview;
    public ListView activity_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
