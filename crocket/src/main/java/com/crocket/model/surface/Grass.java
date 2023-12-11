package com.crocket.model.surface;

public class Grass extends Surface{
    private static final double FRICTION = 0.99;
    public Grass(int xPosition, int yPosition){
        super(xPosition, yPosition);
    }

    public double getFriction(){
        return FRICTION;
    }

}
