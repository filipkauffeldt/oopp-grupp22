package com.crocket.model;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;

public class PassTargetEvent{
    private Ball ball;
    private Entity target;

    public PassTargetEvent(Ball ball, Entity target) {
        this.ball = ball;
        this.target = target;
    }

    public Ball getBall() {
        return ball;
    }

    public Entity getTarget() {
        return target;
    }
}
