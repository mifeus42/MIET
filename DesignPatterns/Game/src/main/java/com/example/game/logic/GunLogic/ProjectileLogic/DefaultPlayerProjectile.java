package com.example.game.logic.GunLogic.ProjectileLogic;

import com.example.game.Data;
import com.example.game.logic.CharacterLogic.Character;
import com.example.game.logic.CharacterLogic.EnemyRegular;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.ScreenObject;
import com.example.game.logic.General.Speed;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class DefaultPlayerProjectile extends IProjectile {

    public int damage;

    public DefaultPlayerProjectile(Position position){
        super(Data.PROJECTILE_PLAYER_IMAGE, position, new Speed(0,-Data.PROJECTILE_SPEED_Y));
        damage=Data.PROJECTILE_PLAYER_DAMAGE;
    }

    public boolean move(ArrayList<Character> characters) {
        for(Character character: characters){
            if(checkCollision(character)){
                damage(character);
                return false;
            }
        }
        if(position.y > 0) {
            position.y += speed.y;
            return true;
        }
        return false;
    }

    public void damage(Character enemy){
        enemy.takeDamage(damage);
    }
}