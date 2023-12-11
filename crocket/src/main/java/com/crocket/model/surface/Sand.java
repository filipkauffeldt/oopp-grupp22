package com.crocket.model.surface;

public class Sand extends Surface {
    private static final double FRICTION = 0.98;
    public Sand(int xPosition, int yPosition){
        super(xPosition, yPosition);
    }

    public double getFriction(){
        return FRICTION;
    }
}
