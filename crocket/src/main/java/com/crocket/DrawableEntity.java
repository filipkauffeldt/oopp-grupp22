package com.crocket;

public class DrawableEntity {
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int rotation;
    private EntityType type;
    
    public DrawableEntity(int xPosition, int yPosition, int width, int height, int rotation, EntityType type) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRotation() {
        return rotation;
    }

    public EntityType getType() {
        return type;
    }
}
