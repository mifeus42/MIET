package com.example.game.logic.GunLogic.ProjectileLogic;

import com.example.game.logic.CharacterLogic.Character;
import com.example.game.logic.CharacterLogic.Player;
import com.example.game.logic.General.MovingObject;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import javafx.scene.image.Image;

public abstract class IProjectile extends MovingObject {

    protected IProjectile(Image image, Position position, Speed speed){
        super(image, position, speed);
    }

    public abstract boolean move(Character character);

    public abstract void damage(Character character);
}
