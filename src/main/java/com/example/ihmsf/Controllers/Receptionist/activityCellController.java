package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Activity;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class activityCellController implements Initializable {
    public Label doctorNameLabel;
    public Label doctorStatusLabel;
    private final Activity activity;

    public activityCellController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorNameLabel.setText(activity.getDoctorName().get());
        doctorStatusLabel.setText(activity.getStatus().get());
    }
}
