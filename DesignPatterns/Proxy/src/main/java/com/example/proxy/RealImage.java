package com.example.proxy;

import javafx.scene.image.Image;

public class RealImage {
    private double height;
    private double width;
    private Image image;

    RealImage(Image image){
        this.image = image;
        height = image.getHeight();
        width = image.getWidth();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Image getImage() {
        return image;
    }
}
