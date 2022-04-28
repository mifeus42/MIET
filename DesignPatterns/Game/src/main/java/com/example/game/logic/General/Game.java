package com.example.game.logic.General;

import com.example.game.logic.CharacterLogic.EnemyRegular;
import com.example.game.logic.CharacterLogic.Player;
import com.example.game.Data;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import com.example.game.logic.ObserverInterface.IObserver;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
public class Game implements IObserver {
    private Player player;
    private ArrayList<EnemyRegular> enemyArray;
    private ArrayList<IProjectile> projectileArray;

    public Game(){
        enemyArray = new ArrayList<>();
        projectileArray = new ArrayList<>();
        setUp();
    }

    private void setUp(){
        player = new Player(Data.PLAYER_IMAGE, Data.PLAYER_SPAWN_POSITION, new Speed(0,0), Data.PLAYER_HEALTH, Data.PLAYER_GUN);
        for(int i = 0; i < Data.ENEMY_REGULAR_COUNT; i++){
            enemyArray.add(new EnemyRegular(Data.ENEMY_REGULAR_IMAGE, new Position((i * (Data.ENEMY_REGULAR_WIDTH + Data.SPAWN_ENEMY_GAP)), 0), new Speed(Data.ENEMY_REGULAR_SPEED_X, Data.ENEMY_REGULAR_SPEED_Y), Data.ENEMY_REGULAR_HEALTH, Data.ENEMY_REGULAR_GUN));
            enemyArray.get(i).RegisterObserver(this);
        }
    }

    public void startGame(GraphicsContext graphicsContext){
        playGame(graphicsContext);
    }

    public void playGame(GraphicsContext graphicsContext){
        for(IProjectile projectile : projectileArray){
            projectile.move();
            graphicsContext.drawImage(projectile.getImage(), projectile.position.x, projectile.position.y);
        }
        player.move();
        graphicsContext.drawImage(player.getImage(), player.position.x, player.position.y);
        for(EnemyRegular enemyRegular : enemyArray){
            projectileArray.add(enemyRegular.shoot());
            enemyRegular.move();
            graphicsContext.drawImage(enemyRegular.getImage(), enemyRegular.position.x, enemyRegular.position.y);
        }
        projectileArray.add(player.shoot());
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void Update(Object object) {
        if(object.getClass() == Player.class){
            System.out.println("loh");
        }
        else{
            EnemyRegular enemy = (EnemyRegular) object;
            player.increaseScore(enemy.getGiftScore());
            enemyArray.remove(enemy);
        }
    }
}
