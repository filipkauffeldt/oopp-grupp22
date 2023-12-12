package com.crocket.model.entity;



class Hitbox {
    private int width;
    private int height;
    private double xPosition;
    private double yPosition;

    public Hitbox(int width, int height, double xPosition, double yPosition) {
        this.width = width;
        this.height = height;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    protected double getxPosition() {
        return xPosition;
    }

    protected double getyPosition() {
        return yPosition;
    }

    protected void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    protected void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

}
