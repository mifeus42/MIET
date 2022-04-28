package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.Gain;
import com.example.game.logic.GunLogic.Gun;
import javafx.scene.image.Image;

public class EnemyRegular extends Character  {
    private static final double dropGainChance = Data.ENEMY_REGULAR_DROP_GAIN_CHANCE;
    private int giftScore;

    public EnemyRegular(Image image, Position position, Speed speed, int health, Gun gun){
        super(image, position, speed, health, gun);
        giftScore = Data.ENEMY_REGULAR_GIFT_SCORE;
    }

    @Override
    public boolean move() {
        if (!(position.x + width <= Data.BOARD_WIDTH) || !(position.x >= 0)) {
            position.y += speed.y;
            speed.x *= -1;
        }
        position.x += speed.x;
        return true;
    }

    public int getGiftScore() {
        return giftScore;
    }
}
