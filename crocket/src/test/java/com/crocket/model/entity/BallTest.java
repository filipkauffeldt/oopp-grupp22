package com.crocket.model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallTest {
    private Ball ball = new Ball(19, 19, 20, 20, 2);

    @Before
    public void reset_ball(){
        ball = new Ball(19, 19, 20, 20, 2);
    }

    @Test
    public void test_starting_ball_xvelocty(){
        ball.startBall(1, 0, 4);
        assertEquals( 2, ball.getxVelocity(), 0.0001);
    }

    @Test
    public void  test_starting_ball_yvelocity(){
        ball.startBall(0, 1, 4);
        assertEquals(2, ball.getyVelocity(), 0.0001);
    }

    @Test
    public void test_if_move_method_moves_correctly_x(){
        ball.startBall(1, 0, 4);
        ball.move();
        assertEquals(22, ball.getxPosition(), 0.0001);
    }

    @Test
    public void test_if_move_method_moves_correctly_y(){
        ball.startBall(0, 1, 4);
        ball.move();
        assertEquals(22, ball.getyPosition(), 0.0001);
    }
}
