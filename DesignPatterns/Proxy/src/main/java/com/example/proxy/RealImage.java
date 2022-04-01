package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RealImage {
    private Image image;

    RealImage(Image image){
        this.image = image;
    }

    public void draw(Rectangle rectangle){
        rectangle.setFill(new ImagePattern(image));
    }


    public Image getImage() {
        return image;
    }
}
