package com.example.game.logic.CharacterLogic;

import com.example.game.logic.GunLogic.Gun;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import javafx.scene.image.Image;

public class Player extends Character {
    private int score;

    public Player(Image image, Position position, Speed speed, int health, Gun gun){
        super(image, position, speed, health, gun);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score){
        this.score += score;
    }

    @Override
    public boolean move() {
        super.move();
        return true;
    }

    public void setSpeed(double speedX) {
        speed.x = speedX;
    }
}
