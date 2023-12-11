package com.crocket.model.surface;

import com.crocket.model.entity.Ball;
import com.crocket.shared.SurfaceType;
import com.crocket.model.Level1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// // 400x, 600y: Ice
// // 1000x, 1400y: Sand

public class SurfaceHandlerTest {
    Ball ball = new Ball(19, 19, 50, 50, 2);
    Level1 level = new Level1();
    SurfaceType[][] tilemap = level.getLevelSurfacemap();
    SurfaceHandler surfacehandler = SurfaceHandler.getInstance();

    @Test
    public void test_if_ball_friction_updates_properly_at_grass(){
        ball.setxPosition(50);
        ball.setyPosition(50);
        surfacehandler.setSurfaceMap(tilemap);
        surfacehandler.updateFriction(ball);
        assertEquals(0.99, ball.getFriction(), 0.01);
    }

    @Test
    public void test_if_ball_friction_updates_properly_at_ice(){
        ball.setxPosition(450);
        ball.setyPosition(650);
        surfacehandler.setSurfaceMap(tilemap);
        surfacehandler.updateFriction(ball);
        assertEquals(0.995, ball.getFriction(), 0.01);
    }

    @Test
    public void test_if_ball_friction_updates_properly_at_sand(){
        ball.setxPosition(1050);
        ball.setyPosition(1450);
        surfacehandler.setSurfaceMap(tilemap);
        surfacehandler.updateFriction(ball);
        assertEquals(0.98, ball.getFriction(), 0.01);
    }

    @Test
    public void test_if_setSurfaceMap_gets_the_correct_surface(){
        surfacehandler.setSurfaceMap(tilemap);
        for(Surface s : surfacehandler.getSurfaceMap()){
            if(s.getxPosition() == 0 && s.getyPosition() == 0){
                assertTrue(s instanceof Grass);
            }
            if(s.getxPosition() == 400 && s.getyPosition() == 600){
                assertTrue(s instanceof Ice);
            }
            if(s.getxPosition() == 1000 && s.getyPosition() == 1400){
                assertTrue(s instanceof Sand);
            }
        }
    }
}