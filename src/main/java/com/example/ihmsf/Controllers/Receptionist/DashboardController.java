package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Views.RoomsCellFactory;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
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
        bindData();
        initRooms();
        rooms_listview.setItems(Model.getInstance().getRooms());
        rooms_listview.setCellFactory(e -> new RoomsCellFactory());
    }
    private void bindData(){
//        user_name.textProperty().bind(Bindings.concat("Hi, ").concat(Model.getInstance().getReciptionist().firstNameProperty());
//        login_date.setText("Today, "+ LocalDate.now());

    }
    private void initRooms(){
        if (Model.getInstance().getRooms().isEmpty()){
            Model.getInstance().setRooms();
        }
    }
}
