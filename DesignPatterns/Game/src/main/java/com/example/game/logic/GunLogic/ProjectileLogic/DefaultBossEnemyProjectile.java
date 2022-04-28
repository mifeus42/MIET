package com.example.game.logic.GunLogic.ProjectileLogic;

import com.example.game.Data;
import com.example.game.logic.CharacterLogic.Character;
import com.example.game.logic.CharacterLogic.Player;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import javafx.scene.image.Image;

public class DefaultBossEnemyProjectile extends IProjectile{

    public int damage;

    public DefaultBossEnemyProjectile(Position position){
        super(Data.PROJECTILE_ENEMY_BOSS_IMAGE, position, new Speed(0,Data.PROJECTILE_SPEED_Y));
        damage=Data.PROJECTILE_ENEMY_BOSS_DAMAGE;
    }

    @Override
    public boolean move(Character player) {
        if(position.y < Data.BOARD_HEIGHT) {
            position.y += speed.y;
            return true;
        }
        else if (checkCollision(player)){
            damage(player);
        }
        return false;
    }

    public void damage(Character player){
        player.takeDamage(damage);
    }
}
