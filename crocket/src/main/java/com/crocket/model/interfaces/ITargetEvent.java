package com.crocket.model.interfaces;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;

public interface ITargetEvent {
    public Entity getTarget();
    public Ball getBall();
}
