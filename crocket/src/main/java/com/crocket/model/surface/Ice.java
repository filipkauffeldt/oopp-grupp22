package com.crocket.model.surface;

public class Ice extends Surface{
    private static final double FRICTION = 0.995;
    public Ice(int xPosition, int yPosition){
        super(xPosition, yPosition);
    }

    public double getFriction(){
        return FRICTION;
    }
}
