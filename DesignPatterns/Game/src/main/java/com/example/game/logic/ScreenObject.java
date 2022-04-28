package com.example.game.logic;

import javafx.scene.image.Image;

public class ScreenObject {
    private Image image;
    protected double width;
    protected double height;
    protected Position position;

    public ScreenObject(Image image, Position position) {
        this.image = image;
        this.position = position;
        width = image.getWidth();
        height = image.getHeight();
    }

    public Image getImage() {
        return image;
    }

    public void draw(){}
}
