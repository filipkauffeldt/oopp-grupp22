package com.crocket.model.entity;



class Hitbox {
    private int width;
    private int height;
    private double x;
    private double y;

    public Hitbox(int width, int height, double xPosition, double yPosition) {
        this.width = width;
        this.height = height;
        this.x = xPosition;
        this.y = yPosition;
    }

    protected double getxPosition() {
        return x;
    }

    protected double getyPosition() {
        return y;
    }

    protected void setxPosition(double xPosition) {
        this.x = xPosition;
    }

    protected void setyPosition(double yPosition) {
        this.y = yPosition;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

}
