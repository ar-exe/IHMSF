package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.AvailableDoctorCellController;
import com.example.ihmsf.Models.Doctor;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class AvailableDoctorsCellFactory extends ListCell<Doctor> {
    @Override
    protected void updateItem(Doctor doctor, boolean empty) {
        super.updateItem(doctor, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/AvailableDoctorsCell.fxml"));
            AvailableDoctorCellController controller = new AvailableDoctorCellController(doctor);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERROR accessing AvailableDoctorCell.fxml (AvailableDoctorsCellFactory.java)");
        }
    }
}}
