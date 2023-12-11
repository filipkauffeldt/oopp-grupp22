package com.crocket.model.surface;

public abstract class Surface {
    private static final int SIZE = 100;
    private int xPosition;
    private int yPosition;

    public Surface(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public abstract double getFriction();

    public int getSize(){
        return SIZE;
    }

    public int getxPosition(){
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }
}
