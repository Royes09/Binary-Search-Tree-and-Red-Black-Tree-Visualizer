package com.royes.sda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 720);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Tree visualizer");
        stage.setMinWidth(1400);
        stage.setMinHeight(720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}