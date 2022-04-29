package com.example.game;

import com.example.game.logic.General.State.StateGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Board board = new Board();
        stage.setScene(new Scene(new StackPane(board)));
        stage.setTitle("GAME");
        stage.show();
        board.draw();
    }

    public static void main(String[] args) {
        launch();
    }
}