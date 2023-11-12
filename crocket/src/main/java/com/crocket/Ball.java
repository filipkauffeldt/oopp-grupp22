package com.crocket;
public class Ball extends Entity implements IMovable{
    private double mass;
    private String powerUp;
    private double xVelocity;
    private double yVelocity;

    public Ball(int width, int height, double xPosition, double yPosition, double mass) {
        super(width, height, xPosition, yPosition);
        //TODO Auto-generated constructor stub
    }

    public double getxVelocity(){
        return xVelocity;
    }

    public double getyVelocity(){
        return yVelocity;
    }

    public void startBall(double cosinus, double sinus, double power){
        this.xVelocity = (power*cosinus)/mass;
        this.yVelocity = (power*sinus)/mass;
    }

    public void move(){
        this.setxPosition((this.getxPosition()+xVelocity));
        this.setyPosition((this.getyPosition()+yVelocity));
    }
}
