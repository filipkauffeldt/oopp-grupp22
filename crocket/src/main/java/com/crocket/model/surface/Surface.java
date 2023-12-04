package com.crocket.model.surface;

public abstract class Surface {
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private double friction;

    public Surface(int width, int height, int xPosition, int yPosition)
    {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition(){
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public double getFriction(){
        return friction;
    }
}
