package com.example.proxy;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class ProxyImage {

    private double height;
    private double width;
    private double x;
    private double y;
    public Rectangle rectangle;
    private RealImage realImage;

    ProxyImage(Image image){
        x = 100;
        y = 100;
        height = image.getHeight();
        width = image.getWidth();
        rectangle = new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
