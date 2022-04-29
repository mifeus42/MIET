package com.example.game;

import com.example.game.logic.General.State.IState;
import com.example.game.logic.General.State.StateGame;
import com.example.game.logic.General.State.StateMenu;
import javafx.scene.canvas.Canvas;

public class Board extends Canvas {
    private IState state;
    public Board(){
        state = new StateMenu(this);
        this.setWidth(Data.BOARD_WIDTH);
        this.setHeight(Data.BOARD_HEIGHT);
    }
    public void changeState(IState state){
        this.state = state;
    }
    public void draw(){
        state.draw();
    }
}
