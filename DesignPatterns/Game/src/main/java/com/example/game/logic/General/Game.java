package com.example.game.logic.General;

import com.example.game.logic.CharacterLogic.*;
import com.example.game.logic.CharacterLogic.Character;
import com.example.game.logic.GunLogic.ProjectileLogic.DefaultPlayerProjectile;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import com.example.game.logic.ObserverInterface.IObserver;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;

public class Game implements IObserver {
    private Player player;
    private Enemies enemies;
    private final ArrayList<IProjectile> projectileArray;

    private int shootTime = 0;
    private final ArrayList<Character> playerScreenObject;

    public Game(){
        projectileArray = new ArrayList<>();
        playerScreenObject = new ArrayList<>();
        setUp();
    }

    private void setUp(){
        player = new Player();
        player.RegisterObserver(this);
        playerScreenObject.add(player);
        enemies = new Enemies(this);
        Boss boss = new Boss();
        boss.RegisterObserver(this);
        enemies.addEnemy(boss);
    }

    public void startGame(GraphicsContext graphicsContext){
        draw(graphicsContext);
    }

    public void draw(GraphicsContext graphicsContext){
        graphicsContext.fillText("Score:" + player.getScore() + "\n" + "Health: " +  player.getHealth(), 20, 40);
        ArrayList<Character> enemyScreenObject = new ArrayList<>(enemies.getEnemies());

        Iterator<IProjectile> projectileIterator = projectileArray.iterator();
        while (projectileIterator.hasNext()){
            IProjectile projectile = projectileIterator.next();
            if(projectile.getClass() == DefaultPlayerProjectile.class){
                if(!projectile.move(enemyScreenObject)){
                    projectileIterator.remove();
                }
            }
            else if(!projectile.move(playerScreenObject)){
                projectileIterator.remove();
            }
            projectile.draw(graphicsContext);
        }

        player.move();
        player.draw(graphicsContext);
        if(shootTime % 30 == 0) {
            projectileArray.add(player.shoot());
        }

        enemies.move();
        enemies.draw(graphicsContext);
        if(shootTime % 50 == 0) {
            projectileArray.addAll(enemies.shootAll());
        }
        shootTime++;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void Update(Object object) {
        if(object.getClass() == Player.class){
            System.out.println("!!!!");
        }
        else {
            IEnemy enemy = (IEnemy) object;
            player.increaseScore(enemy.getGiftScore());
            enemies.removeEnemy(enemy);
            if(enemies.getEnemies().isEmpty()){
                enemies = new Enemies(this);
                Boss boss = new Boss();
                boss.RegisterObserver(this);
                enemies.addEnemy(boss);
            }
        }
    }
}
