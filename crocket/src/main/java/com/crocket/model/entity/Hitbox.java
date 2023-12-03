package com.crocket.model.entity;

class Hitbox {
    private double xPosition;
    private double yPosition;
    
    private int width;
    private int height;
    
    Hitbox(int width, int height, double xPosition, double yPosition) {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public double getxPosition() {
        return xPosition;
    }
    
    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }
    
    public double getyPosition() {
        return yPosition;
    }
    
    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
