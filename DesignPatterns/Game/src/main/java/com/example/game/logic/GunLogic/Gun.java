package com.example.game.logic.GunLogic;

import com.example.game.logic.General.Position;
import com.example.game.logic.GunLogic.ProjectileLogic.Creators.ProjectileCreator;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;

public class Gun {
    private ProjectileCreator projectileCreator;

    public Gun(ProjectileCreator projectileCreator){
        this.projectileCreator = projectileCreator;
    }

    public IProjectile shot(Position position){
        return projectileCreator.CreateProjectile(position);
    }
}
