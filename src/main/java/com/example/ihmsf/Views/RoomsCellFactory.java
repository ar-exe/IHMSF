package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.RoomsCellController;
import com.example.ihmsf.Models.Rooms;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class RoomsCellFactory extends ListCell<Rooms> {
    @Override
    protected void updateItem(Rooms room, boolean empty) {
        super.updateItem(room, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/Reciptionist/RoomsCell.fxml"));
            RoomsCellController controller = new RoomsCellController(room);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
