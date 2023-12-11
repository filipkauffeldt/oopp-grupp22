package com.crocket.model.surface;

import java.util.HashSet;
import java.util.Set;

import com.crocket.model.entity.Ball;
import com.crocket.shared.SurfaceType;

public class SurfaceHandler {
    private static SurfaceHandler instance = null;
    private Set<Surface> surfaceMap;

    private SurfaceHandler() {
    }

    public static SurfaceHandler getInstance() {
        if (instance == null) {
            instance = new SurfaceHandler();
        }
        return instance;
    }

    public Set<Surface> getSurfaceMap() {
        return surfaceMap;
    }

    public void setSurfaceMap(SurfaceType[][] tilemap){
        Set<Surface> classSurfaceMap = new HashSet<Surface>();
        for(int i = 0; i < tilemap.length; i++){
            for(int j = 0; j < tilemap[0].length; j++){
                switch(tilemap[i][j]){
                    case GRASS:
                        classSurfaceMap.add(new Grass(j*100, i*100));
                        break;
                    case ICE:
                        classSurfaceMap.add(new Ice(j*100, i*100));
                        break;
                    case SAND:
                        classSurfaceMap.add(new Sand(j*100, i*100));
                        break;
                }
            }
        }
        this.surfaceMap = classSurfaceMap;
    }

    public void updateFriction(Ball ball) {
        if (surfaceMap == null) {
            throw new IllegalStateException("SurfaceMap is not set");
        }
        for (Surface s : this.surfaceMap) {
            if (intersects(ball, s)){
                applyFriction(ball, s);
            }
        }
    }

    private void applyFriction(Ball ball, Surface surface) {
        double friction = getFrictionConstant(surface);
        ball.setFriction(friction);
    }

    private boolean intersects(Ball ball, Surface surface) {
        double middleXPositionBall = ball.getxPosition() + ball.getWidth() / 2 + 1;
        double middleYPositionBall = ball.getyPosition() + ball.getHeight() / 2 + 1;
        int surfaceX = surface.getxPosition();
        int surfaceY = surface.getyPosition();
        int surfaceSize = surface.getSize();

        boolean xIntersects = middleXPositionBall >= surfaceX && middleXPositionBall <= surfaceX + surfaceSize;
        boolean yIntersects = middleYPositionBall >= surfaceY && middleYPositionBall <= surfaceY + surfaceSize;
        if (xIntersects && yIntersects) {
            return true;
        }
        return false;
    }

    private double getFrictionConstant(Surface surface) {
        double friction = surface.getFriction();
        return friction;
    }
}