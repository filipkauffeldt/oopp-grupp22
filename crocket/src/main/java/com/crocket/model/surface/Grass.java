package com.crocket.model.surface;

public class Grass extends Surface{
    private double friction = 0.1;
    public Grass(){
        super();
    }

    public double getFriction(){
        return friction;
    }

}
