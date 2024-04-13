package com.example.ihmsf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = null;
        try {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/ihmsf/Receptionist.fxml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(fxmlLoader.load(), 950, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}