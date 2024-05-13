package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.TakeAttendanceCellController;
import com.example.ihmsf.Models.Doctor;
import com.example.ihmsf.Models.Model;
import com.example.ihmsf.Models.TakeAttendance;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class takeAttendanceCellFactory extends ListCell<Doctor> {
    @Override
    protected void updateItem(Doctor doctor, boolean empty){
        super.updateItem(doctor, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/TakeAttendanceCell.fxml"));

            // Retrieve the TakeAttendance object for the doctor
            TakeAttendance takeAttendance = Model.getInstance().getTakeAttendance().stream()
                .filter(t -> t.getDoctorID().get().equals(doctor.getDoctorID().get()))
                .findFirst()
                .orElse(null);

            TakeAttendanceCellController controller = new TakeAttendanceCellController(doctor, takeAttendance);
            loader.setController(controller);
            setText(null);
            try{
                setGraphic(loader.load());
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("ERROR accessing TakeAttendanceCell.fxml (takeAttendanceCellFactory.java)");
            }
        }
    }
}