package com.example.game.logic.GunLogic.ProjectileLogic.Creators;

import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.ProjectileLogic.DefaultPlayerProjectile;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import javafx.scene.image.Image;

public class ProjectilePlayerCreator extends ProjectileCreator {

    @Override
    public IProjectile CreateProjectile(Position position){
        return new DefaultPlayerProjectile(position);
    }

}
