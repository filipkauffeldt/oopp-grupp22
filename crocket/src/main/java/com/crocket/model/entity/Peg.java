package com.crocket.model.entity;

import com.crocket.model.interfaces.ICollidable;

public class Peg extends Entity implements ICollidable{

    public Peg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
    }

    public void collideWithBall(Ball ball){
        if(CollisionHandler.intersect(ball, this)){
            // TODO: Notify game that peg has been hit
        }
    }
}
