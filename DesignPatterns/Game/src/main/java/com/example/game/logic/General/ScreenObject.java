package com.example.game.logic.General;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ScreenObject {
    private final Image image;
    protected double width;
    protected double height;
    protected Position position;

    protected ScreenObject() {
        image = null;
    }

    public ScreenObject(Image image, Position position) {
        this.image = image;
        this.position = position;
        width = image.getWidth();
        height = image.getHeight();
    }

    public Image getImage() {
        return image;
    }

    public void draw(GraphicsContext graphicsContext){
        graphicsContext.drawImage(image, position.x, position.y);
    }
}
