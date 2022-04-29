package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.ScreenObject;
import com.example.game.logic.GunLogic.Gun;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import javafx.scene.image.Image;

import java.util.ArrayList;

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
    public boolean move(ArrayList<Character> characters) {
        super.move(characters);
        return true;
    }

    public void setSpeed(double speedX) {
        speed.x = speedX;
    }
}
