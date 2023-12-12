package com.crocket.model;

public class DirectionLine {
    private int degreeAngle;
    private final double height = 100;
    private final double width = 100;
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
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setxPosition(double xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition){
        this.yPosition = yPosition;
    }

    public void setDegreeAngle(int degreeAngle){
        if(degreeAngle > 360 || degreeAngle < 0){
            degreeAngle = (((degreeAngle % 360) + 360) % 360);
        }
        this.degreeAngle = degreeAngle;
    }

    public void incrementDegreeAngle(){
        degreeAngle += 5;

        setDegreeAngle(degreeAngle);
    }

    public void decrementDegreeAngle(){
        degreeAngle -= 5;

        setDegreeAngle(degreeAngle);
    }
}
