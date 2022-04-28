package com.example.proxy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private ProxyImage proxyImage;
    private Button createBoxButton;
    private HBox hBox;
    private Group group;

    @Override
    public void start(Stage stage) throws IOException {
        createBoxButton = new Button("Создать бокс");

        hBox = new HBox(createBoxButton);
        group = new Group(hBox);

        createBoxButton.setOnAction(e -> {
            proxyImage = new ProxyImage(new Image("New Piskel (8).png"));
            group.getChildren().add(proxyImage.rectangleImage);

            proxyImage.rectangleImage.setOnMouseDragged(b -> {
                Translate translate = new Translate();
                translate.setX(b.getX() - proxyImage.rectangleImage.getWidth());
                translate.setY(b.getY() - proxyImage.rectangleImage.getHeight());
                proxyImage.rectangleImage.getTransforms().addAll(translate);
            });

            proxyImage.rectangleImage.addEventFilter(MouseEvent.MOUSE_PRESSED, c -> {
               if(c.isSecondaryButtonDown() && c.getClickCount()>=2){
                   proxyImage.draw();
               }
            });
            createBoxButton.setDisable(true);
        });


        stage.setScene(new Scene(group));
        stage.setWidth(700);
        stage.setHeight(700);
        stage.setTitle("Proxy");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}