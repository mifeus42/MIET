package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RealImage implements IImage{
    private Image image;
    public Rectangle rectangleImage;

    RealImage(Image image, Rectangle rectangleImage){
        this.image = image;
        this.rectangleImage = rectangleImage;
    }

    public void draw(){
        rectangleImage.setFill(new ImagePattern(image));
    }


    public Image getImage() {
        return image;
    }
}
