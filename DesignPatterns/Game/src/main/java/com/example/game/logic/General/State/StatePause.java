package com.example.game.logic.General.State;

import com.example.game.Board;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StatePause implements IState{
    private Board board;
    private StateGame game;

    public StatePause(Board board, StateGame game) {
        this.board = board;
        this.game = game;
    }

    @Override
    public void draw() {
        GraphicsContext graphicsContext = board.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
        graphicsContext.fillText("Пауза\n\nДля продолжения нажмите ENTER\n\nДля выхода в меню нажмите ESCAPE", board.getWidth()/2-150, board.getHeight()/2-100);
        board.getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER -> {
                    board.changeState(game);
                    board.draw();
                }
                case ESCAPE -> {
                    board.changeState(new StateMenu(board));
                    board.draw();
                }
            }
        });
    }
}
