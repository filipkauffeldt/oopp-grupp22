package com.crocket.model.surface;

import com.crocket.model.entity.Ball;

class SurfaceHandler {
    public static boolean intersects(Ball ball, Surface surface){
        double middleXPositionBall = ball.getxPosition() + ball.getWidth()/2 + 1;
        double middleYPositionBall = ball.getyPosition() + ball.getHeight()/2 + 1;

        int sX = surface.getxPosition();
        int sY = surface.getyPosition();
        int sW = surface.getWidth();
        int sH = surface.getHeight();

        if(sX <= middleXPositionBall && middleXPositionBall <= sX + sW){
            if(sY <= middleYPositionBall && middleYPositionBall <= sY + sH){
                return true;
            }
        }
        return false;
    }

    public static double checkSurface(Ball ball, Surface surface){
        double friction = 1;
        if(intersects(ball, surface)){
            if(surface instanceof Grass){
                friction = ((Grass) surface).getFriction();
            } else if(surface instanceof Sand){
                friction = ((Sand) surface).getFriction();
            } else if(surface instanceof Ice){
                friction = ((Ice) surface).getFriction();
            }
            throw new IllegalArgumentException("Unknown surface class");
        }
        return friction;
    }
}
