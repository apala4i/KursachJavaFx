package com.example.kursachjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.ejml.simple.SimpleMatrix;

import java.io.IOException;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Configs.APPLICATION_WINDOW_WIDTH, Configs.APPLICATION_WINDOW_HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}