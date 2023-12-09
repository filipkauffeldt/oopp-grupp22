package com.crocket.model.surface;

public class Ice extends Surface{
    private double friction = 0.05;
    public Ice(){
        super();
    }

    public double getFriction(){
        return friction;
    }
}
