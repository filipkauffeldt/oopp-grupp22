package com.crocket;

public abstract class Entity {
    protected double xPosition;
    protected double yPosition;
    protected int width;
    protected int height;

    private Hitbox hitbox;

    public Entity(int width, int height, double xPosition, double yPosition)
    {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;

        this.hitbox = new Hitbox(width, height, xPosition, yPosition);
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setxPosition(double xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition){
        this.yPosition = yPosition;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

}