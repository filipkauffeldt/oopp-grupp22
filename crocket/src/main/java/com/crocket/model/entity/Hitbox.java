package com.crocket.model.entity;


import java.awt.geom.Rectangle2D;

class Hitbox extends Rectangle2D.Double {

    Hitbox(int width, int height,double xPosition, double yPosition) {
        super(xPosition, yPosition, width, height);
    }

    public double getxPosition() {
        return x;
    }

    public double getyPosition() {
        return y;
    }

    public void setxPosition(double xPosition) {
        this.x = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.y = yPosition;
    }

}