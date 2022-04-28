package com.example.game.logic.CharacterLogic;

import com.example.game.logic.GunLogic.Gun;
import com.example.game.logic.General.MovingObject;
import com.example.game.logic.General.Position;
import com.example.game.logic.General.Speed;
import com.example.game.logic.GunLogic.ProjectileLogic.IProjectile;
import com.example.game.logic.ObserverInterface.IObservable;
import com.example.game.logic.ObserverInterface.IObserver;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Character extends MovingObject implements IObservable {
    private ArrayList<IObserver> observers;
    private int health;
    protected Gun gun;

    public Character(Image image, Position position, Speed speed, int health, Gun gun){
        super(image, position, speed);
        this.health = health;
        this.gun = gun;
        observers = new ArrayList<>();
    }

    public IProjectile shoot(){
        return gun.shot(new Position(position.x + width/2, position.y + height/2));
    }

    public void takeDamage(int damage){
        health-=damage;
        if(checkDie()){
            NotifyObservers();
        }
    }

    public boolean checkDie(){
        return health <= 0;
    }

    @Override
    public void RegisterObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void RemoveObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void NotifyObservers() {
        for(IObserver observer : observers) {
            observer.Update(this);
        }
    }
    
}
