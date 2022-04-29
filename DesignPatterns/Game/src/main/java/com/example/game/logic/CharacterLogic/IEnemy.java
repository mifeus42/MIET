package com.example.game.logic.CharacterLogic;

import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.Gun;
import javafx.scene.image.Image;

public abstract class IEnemy extends Character {
    public IEnemy() {
        super();
    }
    public IEnemy(Image image, Position position, Speed speed, int health, Gun gun) {
        super(image, position, speed, health, gun);
    }

    public abstract int getGiftScore();

    @Override
    public abstract void move();
}
