package com.example.game.logic.CharacterLogic;

import com.example.game.Data;
import com.example.game.logic.General.Position;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import com.example.game.logic.ObserverInterface.IObserver;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Enemies extends IEnemy{
    private ArrayList<IEnemy> enemyArrayList;
    private static final int[] shootOrder = new int[3];
    private int shootCount = 0;
    static {
        shootOrder[0] = 9;
        shootOrder[1] = 4;
        shootOrder[2] = 10;
    }

    public Enemies(IObserver game) {
        super();
        enemyArrayList = new ArrayList<>();
        for(int i = 0; i < Data.ENEMY_REGULAR_COUNT/Data.ENEMY_REGULAR_COUNT_LINE; i++){
            for(int j = 0; j < Data.ENEMY_REGULAR_COUNT_LINE; j++) {
                enemyArrayList.add(new EnemyRegular(new Position((j * (Data.ENEMY_REGULAR_WIDTH + Data.SPAWN_ENEMY_GAP + 20)), Data.ENEMY_REGULAR_SPAWN_POSITION_Y*(i+1))));
                enemyArrayList.get(i*Data.ENEMY_REGULAR_COUNT_LINE+j).RegisterObserver(game);
            }
        }
        RegisterObserver(game);
    }

    public ArrayList<IProjectile> shootAll() {
        ArrayList<IProjectile> projectiles = new ArrayList<>();
        for(int i = 0; i < enemyArrayList.size(); i+=shootOrder[shootCount]){
            projectiles.add(enemyArrayList.get(i).shoot());
        }
        shootCount = (shootCount+1)%3;
        return projectiles;
    }

    @Override
    public boolean checkDie() {
        return enemyArrayList.isEmpty();
    }

    @Override
    public void move() {
        for(IEnemy enemy : enemyArrayList){
            enemy.move();
        }
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        for(IEnemy enemy : enemyArrayList){
            enemy.draw(graphicsContext);
        }
    }

    public void addEnemy(IEnemy enemy){
        enemyArrayList.add(enemy);
    }

    public void removeEnemy(IEnemy enemy){
        enemyArrayList.remove(enemy);
    }
    public ArrayList<IEnemy> getEnemies(){
        return enemyArrayList;
    }

    @Override
    public int getGiftScore() {
        return 322;
    }
}
