package com.example.game;

import com.example.game.logic.General.Position;
import com.example.game.logic.GunLogic.Gun;
import com.example.game.logic.GunLogic.ProjectileLogic.Creators.ProjectileBossEnemyCreator;
import com.example.game.logic.GunLogic.ProjectileLogic.Creators.ProjectilePlayerCreator;
import com.example.game.logic.GunLogic.ProjectileLogic.Creators.ProjectileRegularEnemyCreator;
import javafx.scene.image.Image;

public class Data {
    //General
    static public final Image BOARD_IMAGE = new Image("SpaceX.png");
    static public final double BOARD_WIDTH = 1000;
    static public final double BOARD_HEIGHT = 1000;
    static public final double SPAWN_ENEMY_GAP = 15;
    static public int SCORE_RECORD = 0;

    //Player
    static public final Image PLAYER_IMAGE = new Image("Player_white.png");
    static public final Position PLAYER_SPAWN_POSITION = new Position(BOARD_WIDTH/2, BOARD_HEIGHT - PLAYER_IMAGE.getHeight());
    static public final double PLAYER_SPEED_X = 4;
    static public final int PLAYER_HEALTH = 5;
    static public final Gun PLAYER_GUN = new Gun(new ProjectilePlayerCreator());

    //Enemy Boss
    static public final Image ENEMY_BOSS_IMAGE = new Image("Enemy_boss_x4.png");
    static public final double ENEMY_BOSS_SPEED_X = 0.6;
    static public final double ENEMY_BOSS_SPEED_Y = 0;
    static public final double ENEMY_BOSS_SPAWN_POSITION_X = BOARD_WIDTH/2;
    static public final double ENEMY_BOSS_SPAWN_POSITION_Y = SPAWN_ENEMY_GAP;
    static public final int ENEMY_BOSS_HEALTH = 20;
    static public final Gun ENEMY_BOSS_GUN = new Gun(new ProjectileBossEnemyCreator());
    static public final int ENEMY_BOSS_GIFT_SCORE = 1000;

    //Enemy Regular
    static public final Image ENEMY_REGULAR_IMAGE = new Image("Enemy_regular.png");
    static public final double ENEMY_REGULAR_WIDTH = ENEMY_REGULAR_IMAGE.getWidth();
    static public final double ENEMY_REGULAR_HEIGHT = ENEMY_REGULAR_IMAGE.getHeight();
    static public final double ENEMY_REGULAR_SPEED_X = 1;
    static public final double ENEMY_REGULAR_SPEED_Y = ENEMY_REGULAR_HEIGHT + 5;
    static public final double ENEMY_REGULAR_SPAWN_POSITION_X = ENEMY_REGULAR_IMAGE.getWidth() + SPAWN_ENEMY_GAP;
    static public final double ENEMY_REGULAR_SPAWN_POSITION_Y = ENEMY_BOSS_IMAGE.getHeight() + ENEMY_REGULAR_IMAGE.getHeight() + SPAWN_ENEMY_GAP;
    static public final int ENEMY_REGULAR_HEALTH = 1;
    static public final Gun ENEMY_REGULAR_GUN = new Gun(new ProjectileRegularEnemyCreator());
    static public final int ENEMY_REGULAR_COUNT = 35;
    static public final int ENEMY_REGULAR_COUNT_LINE = 10;
    static public final int ENEMY_REGULAR_GIFT_SCORE = 100;

    //Projectile
    static public final double PROJECTILE_SPEED_Y = 3;

    static public final Image PROJECTILE_PLAYER_IMAGE = new Image("Player_projectileX.png");
    static public final int PROJECTILE_PLAYER_DAMAGE = 1;
    static public final Image PROJECTILE_ENEMY_BOSS_IMAGE = new Image("Enemy_boss_projectile_x3.png");
    static public final int PROJECTILE_ENEMY_REGULAR_DAMAGE = 1;
    static public final Image PROJECTILE_ENEMY_REGULAR_IMAGE = new Image("Enemy_regular_projectileX4.png");
    static public final int PROJECTILE_ENEMY_BOSS_DAMAGE = 2;

}
