package com.crocket;

public abstract class Obstacle extends Entity implements ICollidable{

    public Obstacle(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
    }
}
