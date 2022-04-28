package com.example.game.logic.General;

import javafx.scene.image.Image;

public class ScreenObject {
    private final Image image;
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
}
