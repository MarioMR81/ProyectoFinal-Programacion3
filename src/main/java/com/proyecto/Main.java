package com.proyecto;


import javafx.application.Application;
import javafx.stage.Stage;
import vista.AppView;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppView appView = new AppView(primaryStage);

    }

}