package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class ProxyImage implements IImage {

    private Image image;
    public Rectangle rectangleImage;
    private RealImage realImage;

    ProxyImage(Image image){
        this.image = image;
        rectangleImage = new Rectangle(100,100,image.getWidth(),image.getHeight());
    }

    public void draw(){
        if(realImage == null){
            realImage = new RealImage(image, rectangleImage);
        }
        realImage.draw();
    }

}
