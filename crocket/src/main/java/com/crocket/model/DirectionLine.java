package com.crocket.model;

import com.crocket.model.entity.Ball;
import com.crocket.model.interfaces.IEntityVisitor;

public class DirectionLine {
    private int degreeAngle;
    private final double HEIGHT = 100;
    private final double WIDTH = 100;
    private double xPosition;
    private double yPosition;

    public DirectionLine(int degreeAngle, double xPosition, double yPosition){
        setDegreeAngle(degreeAngle);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    } 

    public int getDegreeAngle() {
        return degreeAngle;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    } 
 
    public double getHeight() {
        return HEIGHT;
    }

    public double getWidth() {
        return WIDTH;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public void setPositionToBall(Ball ball) {
        setxPosition(ball.getxPosition() - WIDTH/2 + ball.getWidth()/2);
        setyPosition(ball.getyPosition() - HEIGHT/2 + ball.getHeight()/2);
    }

    public void setDegreeAngle(int degreeAngle) {
        if(degreeAngle > 360 || degreeAngle < 0){
            degreeAngle = (((degreeAngle % 360) + 360) % 360);
        }
        this.degreeAngle = degreeAngle;
    }

    public void incrementDegreeAngle() {
        degreeAngle += 5;

        setDegreeAngle(degreeAngle);
    }

    public void decrementDegreeAngle() {
        degreeAngle -= 5;

        setDegreeAngle(degreeAngle);
    }

    public void accept(IEntityVisitor visitor) {
        visitor.visit(this);
    }
}
