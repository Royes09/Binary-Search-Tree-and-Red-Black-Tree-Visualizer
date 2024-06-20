package com.royes.sda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    public Button rb;
    @FXML
    public Button bst;

    String str = "test";

    @FXML
    public void gotoRB() throws IOException {
        Stage stage = (Stage) rb.getScene().getWindow();
        FXMLLoader fxmlLoader = changeScene(stage, "redblack.fxml");
        RBController controller = fxmlLoader.getController();
    }

    @FXML
    public void gotoBST() throws IOException {
        Stage stage = (Stage) bst.getScene().getWindow();
        FXMLLoader fxmlLoader = changeScene(stage, "bst.fxml");
        BSTController controller = fxmlLoader.getController();
//        controller.changeLabel(str);
    }

    public FXMLLoader changeScene(Stage stage, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 720);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Tree visualizer");
        stage.setScene(scene);
        stage.show();
        return fxmlLoader;
    }

}