package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.Speed;

public class Player extends Character {
    private int score;

    public Player(){
        super(Data.PLAYER_IMAGE, Data.PLAYER_SPAWN_POSITION, new Speed(0, 0), Data.PLAYER_HEALTH, Data.PLAYER_GUN);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score){
        this.score += score;
    }

    @Override
    public void move() {
        if(!(position.x <= 0 && speed.x <0 || position.x + Data.PLAYER_IMAGE.getWidth() > Data.BOARD_WIDTH && speed.x >0)){
            position.x += speed.x;
        }
    }

    public void setSpeed(double speedX) {
        speed.x = speedX;
    }
}
