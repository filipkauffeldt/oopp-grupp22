package com.crocket.model.surface;

public abstract class Surface {
    private int size = 100;
    private double xPosition;
    private double yPosition;

    public Surface(){
    }

    public abstract double getFriction();

    public int getSize(){
        return size;
    }

    public double getxPosition(){
        return xPosition;
    }

    public double getyPosition(){
        return yPosition;
    }

    public void setxPosition(double xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition){
        this.yPosition = yPosition;
    }
}
