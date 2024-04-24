package com.example.ihmsf;

import com.example.ihmsf.Models.Model;

import javafx.stage.Stage;
import javafx.application.Application;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
