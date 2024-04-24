package com.example.ihmsf.Views;

import com.example.ihmsf.Controllers.Receptionist.ReciptionistController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    //Reciptionist View
    private AnchorPane dashboardView;
    public ViewFactory() {}
    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));

        createStage(loader);
    }
    public void showReciptionistDashboard(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Reciptionist/Reciptionist.fxml"));
        ReciptionistController reciptionistController = new ReciptionistController();
        loader.setController(reciptionistController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("IHMS");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}