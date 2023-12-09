package com.crocket.model.surface;

public class Sand extends Surface {
    private double friction = 0.2;
    public Sand(){
        super();
    }

    public double getFriction(){
        return friction;
    }

    public Sand getInstance(){
        return new Sand();
    }
}
