package com.crocket.model.surface;

public class Ice extends Surface{
    private final double friction = 0.995;
    public Ice(int xPosition, int yPosition){
        super(xPosition, yPosition);
    }

    public double getFriction(){
        return friction;
    }
}
