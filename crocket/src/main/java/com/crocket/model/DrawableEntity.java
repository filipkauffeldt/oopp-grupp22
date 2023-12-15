package com.crocket.model;

import com.crocket.shared.EntityType;

public class DrawableEntity {
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int rotation;
    private EntityType type;
    private boolean active;
    
    public DrawableEntity(int xPosition, int yPosition, int width, int height, int rotation, EntityType type, boolean active) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.rotation = rotation;
        this.type = type;
        this.active = active;
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
    
    public double getCosinus() {
        return Math.cos(Math.toRadians(rotation));
    }

    public double getSinus() {
        return Math.sin(Math.toRadians(rotation));
    }

    public EntityType getType() {
        return type;
    }

    public String getTypeName() {
        return type.name();
    }

    public boolean isActive() {
        return active;
    }
}
