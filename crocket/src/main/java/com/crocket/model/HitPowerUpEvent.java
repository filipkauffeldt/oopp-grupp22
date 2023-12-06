package com.crocket.model;

import com.crocket.model.interfaces.IPowerUp;
import com.crocket.model.entity.Ball;

public class HitPowerUpEvent {
    private Ball ball;
    private IPowerUp powerUp;

    public HitPowerUpEvent(Ball ball, IPowerUp powerUp) {
        this.ball = ball;
        this.powerUp = powerUp;
    }

    public Ball getBall() {
        return ball;
    }

    public IPowerUp getPowerUp() {
        return powerUp;
    }
}

