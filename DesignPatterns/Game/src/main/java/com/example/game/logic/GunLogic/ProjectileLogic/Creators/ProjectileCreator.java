package com.example.game.logic.GunLogic.ProjectileLogic.Creators;

import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import javafx.scene.image.Image;

public abstract class ProjectileCreator {

    public abstract IProjectile CreateProjectile(Position position);
}
