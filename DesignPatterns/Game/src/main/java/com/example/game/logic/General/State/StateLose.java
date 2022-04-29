package com.example.game.logic.General.State;

import com.example.game.Board;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StateLose implements IState {
    private Board board;
    private int result;

    public StateLose(Board board, int result) {
        this.board = board;
        this.result = result;
    }

    @Override
    public void draw() {
        GraphicsContext graphicsContext = board.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
        graphicsContext.fillText("Поздравляем! Вы набрали " + result + " очков\nРекорд " + result , board.getWidth()/2-150, board.getHeight()/2-100);
        board.getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER -> {
                    board.changeState(new StateGame(board));
                    board.draw();
                }
                case ESCAPE -> Platform.exit();
            }
        });
    }
}
