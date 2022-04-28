package com.example.game.logic.General;

import javafx.scene.image.Image;

public class MovingObject extends ScreenObject {
    protected Speed speed;

    public MovingObject(Image image, Position position, Speed speed){
        super(image, position);
        this.speed = speed;
    }

    public boolean move(){
        position.x += speed.x;
        position.y += speed.y;
        return true;
    }

    public boolean checkCollision(ScreenObject screenObject){
        return !(this.position.y + this.height < screenObject.position.y &&
                this.position.y > screenObject.position.y + screenObject.height &&
                this.position.x + this.width < screenObject.position.x &&
                this.position.x > screenObject.position.x + screenObject.width);
    }

    public Speed getSpeed() {
        return speed;
    }
}
