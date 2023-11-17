package com.crocket;

public class DirectionLine {
    private int degreeAngle;
    private double height;
    private double width;
    private double xPosition;
    private double yPosition;

    public DirectionLine(int degreeAngle, double xPosition, double yPosition, double height, double width){
        if(degreeAngle > 360 || degreeAngle < 0){
            degreeAngle = (((degreeAngle % 360)+360)%360);
        }
        this.degreeAngle = degreeAngle;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
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
        this.degreeAngle = degreeAngle;
    }

    public void incrementDegreeAngle(){
        degreeAngle += 5;
        if (degreeAngle > 360){
            degreeAngle = degreeAngle % 360;
        }
        setDegreeAngle(degreeAngle);
    }

    public void decrementDegreeAngle(){
        degreeAngle -= 5;
        if(degreeAngle < 0){
            degreeAngle = (((degreeAngle % 360)+360)%360);
        }
        setDegreeAngle(degreeAngle);
    }
}
