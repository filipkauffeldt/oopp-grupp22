package com.crocket.model.surface;

public class Grass extends Surface{
    private double friction = 0.1;
    public Grass(int width, int height, int xPosition, int yPosition){
        super(width, height, xPosition, yPosition);
    }

    public double getFriction(){
        return friction;
    }

}
