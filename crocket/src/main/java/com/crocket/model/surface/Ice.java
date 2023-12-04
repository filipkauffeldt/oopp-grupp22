package com.crocket.model.surface;

public class Ice extends Surface{
    private double friction = 0.05;
    public Ice(int width, int height, int xPosition, int yPosition){
        super(width, height, xPosition, yPosition);
    }
}
