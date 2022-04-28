package com.example.game.logic;

import javafx.scene.image.Image;

public class MovingObject extends ScreenObject {
    protected Speed speed;

    MovingObject(Image image, Position position, Speed speed){
        super(image, position);
        this.speed = speed;
    }

    public void move(){
        position.x += speed.x;
        position.y += speed.y;
    }

    public boolean checkCollision(ScreenObject screenObject){
        return !(this.position.y + this.height < screenObject.position.y &&
                this.position.y > screenObject.position.y + screenObject.height &&
                this.position.x + this.width < screenObject.position.x &&
                this.position.x > screenObject.position.x + screenObject.width);
    }
}
