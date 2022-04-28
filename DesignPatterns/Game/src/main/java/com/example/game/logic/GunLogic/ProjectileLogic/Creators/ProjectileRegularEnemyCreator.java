package com.example.game.logic.GunLogic.ProjectileLogic.Creators;

import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.ProjectileLogic.DefaultRegularEnemyProjectile;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import javafx.scene.image.Image;

public class ProjectileRegularEnemyCreator extends ProjectileCreator {

    @Override
    public IProjectile CreateProjectile(Position position){
        return new DefaultRegularEnemyProjectile(position);
    }

}
