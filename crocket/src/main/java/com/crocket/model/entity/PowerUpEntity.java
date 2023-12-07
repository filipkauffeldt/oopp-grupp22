package com.crocket.model.entity;

import com.crocket.model.HitPowerUpEvent;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.IPowerUp;
import com.crocket.model.EventPublisher;


public class PowerUpEntity extends Entity implements ICollidable{
    
    private IPowerUp powerUp;
    private EventPublisher eventPublisher;

    public PowerUpEntity(int width, int height, double xPosition, double yPosition, IPowerUp power) {
        super(width, height, xPosition, yPosition);
        this.powerUp = power;
        this.eventPublisher = EventPublisher.getInstance();

    }

    @Override
    public void collideWithBall(Ball ball){
       if (CollisionHandler.intersect(ball, this)) {
            HitPowerUpEvent event = new HitPowerUpEvent(ball, powerUp);
            eventPublisher.publishEvent(event);
        
        }
        
    }

    public IPowerUp getpowerUp(){
        return this.powerUp;
    }
}
