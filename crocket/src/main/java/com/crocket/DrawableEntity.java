package com.crocket;

public class DrawableEntity {
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private EntityType type;
    
    public DrawableEntity(int xPosition, int yPosition, int width, int height, EntityType type) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public DrawableEntity(Entity entity) {
        this.xPosition = (int) entity.getxPosition();
        this.yPosition = (int) entity.getyPosition();
        this.width = entity.getWidth();
        this.height = entity.getHeight();
        this.type = EntityType.fromClass(entity.getClass());
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

    public EntityType getType() {
        return type;
    }
}
