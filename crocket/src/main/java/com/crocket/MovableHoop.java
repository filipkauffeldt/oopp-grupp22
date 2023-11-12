package com.crocket;

public class MovableHoop extends Hoop implements IMovable {

    private double xVelocity;
    private double yVelocity;

    public MovableHoop(int width, int height, int innerWidth,double xPosition, double yPosition, Direction dir) {
        super(width, height, innerWidth, xPosition, yPosition, dir);
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
}
