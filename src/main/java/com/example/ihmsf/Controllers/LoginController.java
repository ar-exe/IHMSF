package com.example.ihmsf.Controllers;

import com.example.ihmsf.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usernameTextField;
    public TextField passwordTextField;
    public Label loginErrorLabel;
    public Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> onLogin());
    }
    private void onLogin(){
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showReciptionistDashboard();
    }

}
