package com.example.ihmsf.Controllers.Receptionist;

import com.example.ihmsf.Models.Rooms;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomsCellController implements Initializable {
    public Label patientIDCell;
    public Label roomIDCell;
    public Label doctorCell;
    public Label heartbeatCell;
    public Label stateCell;

    private final Rooms room;
    public RoomsCellController(Rooms room) {
        this.room = room;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
