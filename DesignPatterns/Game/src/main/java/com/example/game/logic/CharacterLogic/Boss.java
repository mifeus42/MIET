package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;

public class Boss extends IEnemy {
    private int giftScore;

    public Boss(){
        super(Data.ENEMY_BOSS_IMAGE, new Position(Data.ENEMY_BOSS_SPAWN_POSITION_X - Math.random()*70, Data.ENEMY_BOSS_SPAWN_POSITION_Y), new Speed(Data.ENEMY_BOSS_SPEED_X, Data.ENEMY_REGULAR_SPEED_Y), Data.ENEMY_BOSS_HEALTH, Data.ENEMY_BOSS_GUN);
        giftScore = Data.ENEMY_BOSS_GIFT_SCORE;
    }

    @Override
    public void move() {
        if (position.x > Data.ENEMY_BOSS_SPAWN_POSITION_X + 100 || position.x < Data.ENEMY_BOSS_SPAWN_POSITION_X - 100 - Data.ENEMY_BOSS_IMAGE.getWidth()) {
            speed.x *= -1;
        }
        position.x += speed.x;
    }

    public int getGiftScore() {
        return giftScore;
    }
}
