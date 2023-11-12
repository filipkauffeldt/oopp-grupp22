package com.crocket;

import com.crocket.Ball;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallTest {
    private Ball ball = new Ball(20, 20, 20, 20, 2);
    private double xPosition;
    private double yPosition;

    @Before
    public void reset_ball(){
        ball = new Ball(20, 20, 20, 20, 2);
    }

    @Test
    public void test_starting_ball_xvelocty(){
        ball.startBall(1, 0, 4);
        assertEquals(ball.getxVelocity(), 2, 0.0001);
    }

    @Test
    public void  test_starting_ball_yvelocity(){
        ball.startBall(0, 1, 4);
        assertEquals(ball.getyVelocity(), 2, 0.0001);
    }

    @Test
    public void test_if_move_method_moves_correctly_x(){
        ball.startBall(0, 1, 4);
        ball.setxPosition(this.xPosition + ball.getxVelocity());
        assertEquals(ball.getxPosition(), 21, 0.0001);
    }

    @Test
    public void test_if_move_method_moves_correctly_y(){
        ball.startBall(0, 1, 4);
        ball.setxPosition(this.yPosition + ball.getyVelocity());
        assertEquals(ball.getyPosition(), 21, 0.0001);
    }
}
