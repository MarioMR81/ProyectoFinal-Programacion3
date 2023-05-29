package com.proyecto;

import controller.HojaCalculoController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AppModel;
import model.HojaCalculoModel;
import vista.AppView;
import vista.HojaCalculoView;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppView appView = new AppView(primaryStage);

    }

}