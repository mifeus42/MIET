package com.example.proxy;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    private Timeline timeline;
    private ProxyImage proxyImage;
    private Button createBoxButton;
    private HBox hBox;
    private VBox vBox;

    @Override
    public void start(Stage stage) throws IOException {

        createBoxButton = new Button("Создать бокс");

        hBox = new HBox(createBoxButton);

        vBox = new VBox(hBox);
        vBox.setSpacing(30);
        vBox.setPadding(new Insets(10));

        createBoxButton.setOnAction(e -> {
            proxyImage = new ProxyImage(new Image("Im2.jpg"));
            vBox.getChildren().add(proxyImage.rectangle);
            proxyImage.rectangle.getOnMouseDragged();
            createBoxButton.setDisable(true);

        });

        vBox.setOnMouseClicked(e ->{
            proxyImage.setX(500);
            proxyImage.setY(500);
        });


        stage.setScene(new Scene(vBox));
        stage.setWidth(700);
        stage.setHeight(700);
        stage.setTitle("Proxy");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}