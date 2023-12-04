package com.crocket.model.entity;

import com.crocket.model.interfaces.IMovable;

public class MovablePeg extends Peg implements IMovable{
    private double xVelocity;
    private double yVelocity;

    public MovablePeg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }
}
