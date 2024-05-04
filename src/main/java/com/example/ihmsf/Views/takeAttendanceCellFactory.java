package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.TakeAttendanceCellController;
import com.example.ihmsf.Models.TakeAttendance;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class takeAttendanceCellFactory extends ListCell<TakeAttendance> {
    @Override
    protected void updateItem(TakeAttendance takeAttendance, boolean empty){
        super.updateItem(takeAttendance, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/TakeAttendanceCell.fxml"));
            TakeAttendanceCellController controller = new TakeAttendanceCellController(takeAttendance);
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