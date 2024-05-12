package com.example.ihmsf;

import com.example.ihmsf.Models.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;

import static javafx.application.Application.launch;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
//        FXMLLoader fxmlLoader = null;
//        try {
//            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Users/karem/Documents/GitHub/IHMSF/src/main/resources/FXML/Doctor/DoctorMainForm.fxml"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        Scene scene = new Scene(fxmlLoader.load(), 950, 500);
//        stage.setTitle("IHMSF");
//        stage.setScene(scene);
//        stage.show();
//    }
        //

}
}

