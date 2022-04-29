package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;

public class EnemyRegular extends IEnemy {
    private int giftScore;

    public EnemyRegular(Position position){
        super(Data.ENEMY_REGULAR_IMAGE, position, new Speed(Data.ENEMY_REGULAR_SPEED_X, Data.ENEMY_REGULAR_SPEED_Y), Data.ENEMY_REGULAR_HEALTH, Data.ENEMY_REGULAR_GUN);
        giftScore = Data.ENEMY_REGULAR_GIFT_SCORE;
    }

    @Override
    public void move() {
        if (!(position.x + width <= Data.BOARD_WIDTH) || !(position.x >= 0)) {
            position.y += speed.y;
            speed.x *= -1;
        }
        position.x += speed.x;
    }

    public int getGiftScore() {
        return giftScore;
    }
}
