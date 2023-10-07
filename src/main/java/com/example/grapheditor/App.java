package com.example.grapheditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
//        stage.setTitle("Graph Editor");
//
//        stage.setScene(scene);
//        stage.show();

        stage.setTitle("Graph Editor");

        Label label = new Label("Not clicked");
        Button button = new Button("Click");

        button.setOnAction(value ->  {
            label.setText("Clicked!");
        });

        HBox hbox = new HBox(button, label);

        Scene scene = new Scene(hbox, 200, 100);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}