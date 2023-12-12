package com.crocket.model.interfaces;

import com.crocket.model.entity.Ball;

/**
 * The ICollidable interface represents an object that can collide with a ball in our game.
 * It provides a method to handle such a collision with a ball.
 * 
 * The interface is expected to be implemented by classes that represent objects which can collide with a ball.
 */
public interface ICollidable {

    /**
     * Handles a collision with a ball.
     * 
     * @param ball The ball that this object is colliding with
     */
    public void collideWithBall(Ball ball);
}