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
    String id = usernameTextField.getText().trim();
    String password = passwordTextField.getText().trim();
    String hospitalId = id.substring(0, 3);

    if (id.isEmpty() || password.isEmpty()) {
        loginErrorLabel.setText("ID or password cannot be empty");
        return;
    }

    // Authenticate the user against the database using the id, password, and hospitalId
    boolean isAuthenticated = Model.getInstance().getDatabaseDriver().authenticateUser(id, password, hospitalId);

    if (isAuthenticated) {
        String userType = Model.getInstance().getDatabaseDriver().getUserType(id);
        System.out.println("User Type: " + userType); // Print the user type
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        if ("Doctor".equals(userType)) {
            System.out.println("Showing Doctor Dashboard"); // Print the name of the dashboard
            // Model.getInstance().getViewFactory().showDoctorDashboard();
        } else if ("Reciptionist".equals(userType)) {
            System.out.println("Showing Receptionist Dashboard"); // Print the name of the dashboard
            Model.getInstance().getViewFactory().showReciptionistDashboard();
        } else {
            loginErrorLabel.setText("Invalid user type");
        }
    } else {
        loginErrorLabel.setText("Invalid ID or password");
    }
}

}
