package com.crocket.model.entity;

import com.crocket.model.EventPublisher;
import com.crocket.model.PassTargetEvent;
import com.crocket.model.interfaces.ICollidable;

public class Peg extends Entity implements ICollidable{
    private boolean isHit;
    private EventPublisher eventPublisher;
    private Hitbox scoreHitbox;

    public Peg(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
        this.isHit = false;
        this.eventPublisher = EventPublisher.getInstance();
        this.scoreHitbox = new Hitbox(width, 4, xPosition, yPosition); 

    }

    public void collideWithBall(Ball ball){
        if(CollisionHandler.intersect(ball, scoreHitbox)){
            this.isHit = true;
            PassTargetEvent event = new PassTargetEvent(ball, this);
            eventPublisher.publishEvent(event);
        }
    }
}
