package com.crocket;
public class Hoop extends Entity {

    private Direction direction;
    private double innerHitboxWidth;

    public Hoop(int width, int height, double xPosition, double yPosition, Direction direction, double innerHitboxWidth) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
        this.direction = direction;
        this.innerHitboxWidth = innerHitboxWidth;
    }

    public Direction getDirection(){
        return direction;
    }

    public double getInnerHitboxWidth(){
        return innerHitboxWidth;
    }





}
