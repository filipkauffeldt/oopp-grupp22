package com.crocket;

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
}
