package com.crocket.model.surface;

public class Sand extends Surface {
    private double friction = 0.2;
    public Sand(int width, int height, int xPosition, int yPosition){
        super(width, height, xPosition, yPosition);
    }
}
