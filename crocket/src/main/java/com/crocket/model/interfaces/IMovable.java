package com.crocket.model.interfaces;

public interface IMovable {
    public double getxVelocity();
    public double getyVelocity();
    public void setxVelocity(double xVelocity);
    public void setyVelocity(double yVelocity);
    public double getxPosition();
    public double getyPosition();
    public void move();
}
