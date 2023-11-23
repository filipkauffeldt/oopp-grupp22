package com.crocket;

public class MovableStone extends Stone implements IMovable {
    private double xVelocity;
    private double yVelocity;

    MovableStone(int width, int height, double xPosition, double yPosition){
        super(width, height, xPosition, yPosition);
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

    public void move() {
        this.setxPosition((this.getxPosition() + xVelocity));
        this.setyPosition((this.getyPosition() + yVelocity));
    }
}
