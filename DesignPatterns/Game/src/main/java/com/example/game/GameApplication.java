package com.example.game;

import com.example.game.logic.General.Game;
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

public class GameApplication extends Application {
    private Canvas canvas;
    private Game game;
    private Timeline timeline;
    @Override
    public void start(Stage stage) throws IOException {
        game = new Game();
        canvas = new Canvas(Data.BOARD_WIDTH, Data.BOARD_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        setBackEnd(graphicsContext);

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.setTitle("PING-PONG");
        stage.show();

        timeline = new Timeline(new KeyFrame(Duration.millis(14), e -> run(graphicsContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);

        canvas.getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A -> game.getPlayer().setSpeed(-Data.PLAYER_SPEED_X);
                case D -> game.getPlayer().setSpeed(Data.PLAYER_SPEED_X);
            }
        });
        canvas.getScene().setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case A, D ->  game.getPlayer().setSpeed(0);
            }
        });

        game.startGame(graphicsContext);
        timeline.play();
    }

    private void run(GraphicsContext graphicsContext) {
        setBackEnd(graphicsContext);
        game.draw(graphicsContext);
    }

    private void setBackEnd(GraphicsContext graphicsContext){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
    }


    public static void main(String[] args) {
        launch();
    }
}