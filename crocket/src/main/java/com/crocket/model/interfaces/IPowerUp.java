package com.crocket.model.interfaces;

import com.crocket.model.entity.Ball;

public interface IPowerUp {
    /**
     * Applies the power up to the ball.
     * 
     * @param ball the ball to apply the power up to
     */
    public void applyPowerUp(Ball ball);
}