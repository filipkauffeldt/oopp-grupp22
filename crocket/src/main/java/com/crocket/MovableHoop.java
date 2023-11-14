package com.crocket;

public class MovableHoop extends Hoop implements IMovable {

    private double xVelocity;
    private double yVelocity;
    
    public MovableHoop(int width, int height, double xPosition, double yPosition, Direction direction, double innerHitboxWidth) {
        super(width, height, xPosition, yPosition, direction, innerHitboxWidth);
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
}
