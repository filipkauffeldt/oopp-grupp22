package com.crocket.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.crocket.shared.Direction;

public class HoopTest {
    //TODO: Add tests for all directions of hoop

    public static Ball getTestBall(int x, int y) {
        Ball ball = new Ball(8, 8, x, y, 2);
        return ball;
    }

    public static Hoop getTestHoop(int x, int y) {
        Hoop hoop = new Hoop(20, 20, 10,2, x, y, Direction.NORTH);
        return hoop;
    }
    public static Hoop getVerticalTestHoop(int x, int y) {
        Hoop hoop = new Hoop(20, 20, 10,2, x, y, Direction.EAST);
        return hoop;
    }

    @Test
    public void collide_with_ball_east_top() {
        Ball ball = getTestBall(10, 0);
        Hoop hoop = getVerticalTestHoop(0, 0);
        ball.setxVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop.getLeftHitbox()));
        assertEquals(ball.getxVelocity(), 2.5, 0.0001);
    }

   @Test
    public void collide_with_ball_east_bottom() {
        Ball ball = getTestBall(10, 15);
        Hoop hoop = getVerticalTestHoop(0, 0);
        ball.setxVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop.getRightHitbox()));
        assertEquals(ball.getxVelocity(), 2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_north_left() {
        Ball ball = getTestBall(0,8);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(2.5);
        ball.move();
        hoop.collideWithBall(ball);        
        assertTrue(CollisionHandler.intersect(ball, hoop.getLeftHitbox()));
        assertEquals(ball.getyVelocity(), -2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_north_right() {
        Ball ball = getTestBall(15, 8);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop.getRightHitbox()));
        assertEquals(ball.getyVelocity(), -2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_south_left() {
        Ball ball = getTestBall(0, 21);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop.getLeftHitbox()));
        assertEquals(ball.getyVelocity(), 2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_south_right() { 
        Ball ball = getTestBall(15, 21);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop.getRightHitbox()));
        assertEquals(ball.getyVelocity(), 2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_north_pass_trough() {
        //TODO: Check that player is notified
        Ball ball = getTestBall(6, 10);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop));
        assertEquals(ball.getyVelocity(), -2.5, 0.0001);
    }

    @Test
    public void collide_with_ball_south_pass_trough() {
        //TODO: Check that player is notified
        Ball ball = getTestBall(6, 10);
        Hoop hoop = getTestHoop(0, 0);
        ball.setyVelocity(-2.5);
        ball.move();
        hoop.collideWithBall(ball);
        assertTrue(CollisionHandler.intersect(ball, hoop));
        assertEquals(ball.getyVelocity(), -2.5, 0.0001);
    }
}
