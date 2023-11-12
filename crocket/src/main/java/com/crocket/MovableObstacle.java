package com.crocket;

public class MovableObstacle extends Obstacle implements IMovable{
    private double xVelocity;
    private double yVelocity;

    public MovableObstacle(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
}
