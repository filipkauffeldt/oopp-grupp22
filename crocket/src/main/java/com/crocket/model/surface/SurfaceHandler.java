package com.crocket.model.surface;

import com.crocket.model.entity.Ball;
import com.crocket.model.interfaces.ILevel;
import com.crocket.shared.SurfaceType;

class SurfaceHandler {
    public static SurfaceType intersects(Ball ball, Surface surface, ILevel level){
        double middleXPositionBall = ball.getxPosition() + ball.getWidth()/2 + 1;
        double middleYPositionBall = ball.getyPosition() + ball.getHeight()/2 + 1;
        int tX = (int) Math.floor(middleXPositionBall / surface.getSize());
        int tY = (int) Math.floor(middleYPositionBall / surface.getSize());

        SurfaceType[][] tilemap = level.getLevelSurfacemap();
        return tilemap[tY][tX];
    }

    public static double getFrictionConstant(Ball ball, Surface surface){
        double friction = 1;
        if(intersects(ball, surface)){
            friction = surface.getFriction();
        }
        return friction;
    }
}
