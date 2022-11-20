package com.service.javafx.servicerepairphone.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application{
    public static Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Service of repair phone");
        primaryStage.setScene(new Scene(root, 1600, 900));
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.show();
        primaryStage.setResizable(false);
    }
   public static void main(String[] args) {
        launch(args);

    }
}