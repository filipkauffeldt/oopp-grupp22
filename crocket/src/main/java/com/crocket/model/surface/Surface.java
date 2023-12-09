package com.crocket.model.surface;

public abstract class Surface {
    private int size = 100;
    private int xPosition;
    private int yPosition;

    public Surface(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public abstract double getFriction();

    public int getSize(){
        return size;
    }

    public int getxPosition(){
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }

    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }
}
