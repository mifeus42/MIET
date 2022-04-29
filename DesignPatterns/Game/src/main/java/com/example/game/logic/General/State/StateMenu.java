package com.example.game.logic.General.State;

import com.example.game.Board;
import com.example.game.Data;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StateMenu implements IState{
    private Board board;

    public StateMenu(Board board) {
        this.board = board;
    }

    @Override
    public void draw() {
        GraphicsContext graphicsContext = board.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0, board.getWidth(), board.getHeight());
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
        graphicsContext.fillText("Нажите Enter для начала игры\n\n\nESCAPE для выхода", board.getWidth()/2-150, board.getHeight()/2-100);
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
