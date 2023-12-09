package com.crocket.model.surface;

public class Grass extends Surface{
    private final double friction = 0.99;
    public Grass(int xPosition, int yPosition){
        super(xPosition, yPosition);
    }

    public double getFriction(){
        return friction;
    }

}
