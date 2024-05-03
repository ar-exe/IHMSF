package com.example.ihmsf.Views;


import com.example.ihmsf.Controllers.Receptionist.activityCellController;
import com.example.ihmsf.Models.Activity;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class activityCellFactory extends ListCell<Activity> {
    @Override
    protected void updateItem(Activity activity, boolean empty) {
        super.updateItem(activity, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Receptionist/activityCell.fxml"));
            activityCellController controller = new activityCellController(activity);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
