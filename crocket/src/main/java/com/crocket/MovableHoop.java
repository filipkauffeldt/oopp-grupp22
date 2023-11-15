package com.crocket;

public class MovableHoop extends Hoop implements IMovable {

    private double xVelocity;
    private double yVelocity;

    public MovableHoop(int width, int height, int innerWidth, double xPosition, double yPosition, Direction dir) {
        super(width, height, innerWidth, xPosition, yPosition, dir);
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
