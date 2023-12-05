package com.crocket;

public class PowerUpEntity extends Entity implements ICollidable{
    
    private IPowerUp powerUp;

    public PowerUpEntity(int width, int height, double xPosition, double yPosition, IPowerUp power) {
        super(width, height, xPosition, yPosition);
        this. powerUp = power;
    }

    @Override
    public void collideWithBall(Ball ball){
       if (CollisionHandler.intersect(ball, this)) {
            powerUp.applyPowerUp(ball);}
        
    }

    public IPowerUp getpowerUp(){
        return this.powerUp;
    }
}
