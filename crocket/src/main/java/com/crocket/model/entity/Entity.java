package com.crocket.model.entity;

import com.crocket.model.interfaces.IEntityVisitable;
import com.crocket.model.interfaces.IEntityVisitor;

public abstract class Entity implements IEntityVisitable {
    private double prevXPosition;
    private double prevYPosition;
    private double xPosition;
    private double yPosition;
    private int width;
    private int height;

    private Hitbox hitbox;

    public Entity(int width, int height, double xPosition, double yPosition)
    {
        this.width = width;
        this.height = height;
        this.prevXPosition = xPosition;
        this.prevYPosition = yPosition;
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
        this.prevXPosition = this.getxPosition();
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition){
        this.prevYPosition = this.getyPosition();
        this.yPosition = yPosition;
    }

    public double getPrevXPosition() {
        return prevXPosition;
    }

    public double getPrevYPosition() {
        return prevYPosition;
    }

    public Hitbox getHitbox() {
        return new Hitbox(width, height, xPosition, yPosition);
    }

    public void setHitboxXPosition(double xPosition) {
        this.hitbox.setxPosition(xPosition);
    }

    public void setHitboxYPosition(double yPosition) {
        this.hitbox.setyPosition(yPosition);
    }

    public void accept(IEntityVisitor visitor) {
        visitor.visit(this);
    }
}