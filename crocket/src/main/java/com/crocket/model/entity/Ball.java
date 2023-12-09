package com.crocket.model.entity;

import com.crocket.model.interfaces.IMovable;

public class Ball extends Entity implements IMovable{
    private double mass;
    private String powerUp;
    private double xVelocity;
    private double yVelocity;
    private double friction = 1;

    public Ball(int width, int height, double xPosition, double yPosition, double mass) {
        super(width, height, xPosition, yPosition);
        if(mass <= 0.0){
            throw new IllegalArgumentException("Mass should be above 0");
        }
        this.mass = mass;
    }

    public double getxVelocity(){
        return xVelocity;
    }

    public double getyVelocity(){
        return yVelocity;
    }

    public double getMass(){
        return mass;
    }

    public void setxVelocity(double xVelocity){
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity){
        this.yVelocity = yVelocity;
    }

    public void setFriction(double frictionConstant) {
        if (frictionConstant > 1) {
            throw new IllegalArgumentException("Friction contant must be less than one");
        }
        
        this.friction = frictionConstant;
    }

    public void startBall(double cosinus, double sinus, double power){
        double newXVelocity;
        double newYVelocity;
        mass = getMass();
        newXVelocity = (power*cosinus)/mass;
        newYVelocity = (power*sinus)/mass;
        setxVelocity(newXVelocity);
        setyVelocity(newYVelocity);
    }

    public void move(){
        xVelocity *= friction;
        yVelocity *= friction;

        double newxPosition = getxPosition() + xVelocity;
        double newyPosition = getyPosition() + yVelocity;
        this.setxPosition(newxPosition);
        this.setyPosition(newyPosition);
        getHitbox().setxPosition(newxPosition);
        getHitbox().setyPosition(newyPosition);
    }
}
