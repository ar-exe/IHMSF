package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.AvailableClinicsCellController;
import com.example.ihmsf.Controllers.Receptionist.AvailableDoctorCellController;
import com.example.ihmsf.Models.Clinic;
//import com.example.ihmsf.Models.Doctor;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class AvailableClinicsCellFactory extends ListCell<Clinic> {
    @Override
    protected void updateItem(Clinic clinic, boolean empty) {
        super.updateItem(clinic, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/AvailableClinicsCell.fxml"));
            AvailableClinicsCellController controller = new AvailableClinicsCellController(clinic);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("ERROR accessing AvailableClinicsCell.fxml (AvailableClinicsCellFactory.java)");
            }
        }
    }
}
