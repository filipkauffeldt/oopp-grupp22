package com.crocket.model.entity;

import com.crocket.model.EventPublisher;
import com.crocket.model.PassTargetEvent;
import com.crocket.model.interfaces.ICollidable;

public class Peg extends Entity implements ICollidable{
    private EventPublisher eventPublisher;
    private Hitbox scoreHitbox;

    public Peg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        this.eventPublisher = EventPublisher.getInstance();
        this.scoreHitbox = new Hitbox(width, 4, xPosition, yPosition+height); 

    }

    public void collideWithBall(Ball ball){
        if(CollisionHandler.intersect(ball, scoreHitbox)){
            CollisionHandler.reflect(ball, CollisionHandler.collidedDirection(ball, scoreHitbox));
            PassTargetEvent event = new PassTargetEvent(ball, this);
            eventPublisher.publishEvent(event);
        }
    }
}
