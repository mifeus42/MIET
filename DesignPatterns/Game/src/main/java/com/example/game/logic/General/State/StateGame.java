package com.example.game.logic.General.State;

import com.example.game.Board;
import com.example.game.Data;
import com.example.game.logic.CharacterLogic.*;
import com.example.game.logic.CharacterLogic.Character;
import com.example.game.logic.GunLogic.ProjectileLogic.DefaultPlayerProjectile;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import com.example.game.logic.ObserverInterface.IObserver;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class StateGame implements IObserver, IState {
    private Board board;
    private GraphicsContext graphicsContext;
    private Timeline timeline;

    private Player player;
    private Enemies enemies;
    private final ArrayList<IProjectile> projectileArray;

    private int shootTime = 0;
    private final ArrayList<Character> playerScreenObject;

    public StateGame(Board board){
        projectileArray = new ArrayList<>();
        playerScreenObject = new ArrayList<>();
        this.board = board;
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

    @Override
    public void Update(Object object) {
        if(object.getClass() == Player.class){
            board.changeState(new StateLose(board, player.getScore()));
            Data.SCORE_RECORD = Math.max(player.getScore(), Data.SCORE_RECORD);
            timeline.stop();
            board.draw();
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

    @Override
    public void draw() {
        graphicsContext = board.getGraphicsContext2D();
        timeline = new Timeline(new KeyFrame(Duration.millis(14), e -> run(graphicsContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        board.getScene().setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A -> player.setSpeed(-Data.PLAYER_SPEED_X);
                case D -> player.setSpeed(Data.PLAYER_SPEED_X);
                case ESCAPE -> {
                    board.changeState(new StatePause(board, this));
                    timeline.stop();
                    board.draw();
                }
            }
        });
        board.getScene().setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case A, D ->  player.setSpeed(0);
            }
        });
        timeline.play();
    }

    private void run(GraphicsContext graphicsContext) {
        setBackEnd(graphicsContext);
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
        if(shootTime % 40 == 0) {
            projectileArray.add(player.shoot());
        }

        enemies.move();
        enemies.draw(graphicsContext);
        if(shootTime % 50 == 0) {
            projectileArray.addAll(enemies.shootAll());
        }
        shootTime++;
    }
    private void setBackEnd(GraphicsContext graphicsContext){
        graphicsContext.drawImage(Data.BOARD_IMAGE, 0, 0);
        //graphicsContext.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
    }
}
