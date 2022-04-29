package com.example.game.logic.General;

import com.example.game.logic.CharacterLogic.Character;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovingObject extends ScreenObject {
    protected Speed speed;

    protected MovingObject(){
        super();
    }

    public MovingObject(Image image, Position position, Speed speed){
        super(image, position);
        this.speed = speed;
    }

    public boolean move(ArrayList<Character> characters){
        position.x += speed.x;
        position.y += speed.y;
        for(ScreenObject character: characters){
            if(checkCollision(character)){
                return false;
            }
        }
        return true;
    }
    public void move(){
        position.x += speed.x;
        position.y += speed.y;
    }

    public boolean checkCollision(ScreenObject screenObject){
        return !(this.position.y + this.height < screenObject.position.y ||
                this.position.y > screenObject.position.y + screenObject.height ||
                this.position.x + this.width < screenObject.position.x ||
                this.position.x > screenObject.position.x + screenObject.width);
    }

    public Speed getSpeed() {
        return speed;
    }
}
