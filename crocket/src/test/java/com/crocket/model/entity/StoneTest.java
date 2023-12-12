package com.crocket.model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoneTest {
    private Ball ball = new Ball(19, 19, 0, 0, 2);
    private Stone stone = new Stone(25, 25, 30, 30);
    
    @Before
    public void reset_ball(){
        ball = new Ball(19, 19, 0, 0, 2);
    }

    // Already tested most of the methods in CollisionHandlerTest. Only to see if everything works together.
    @Test
    public void test_if_ball_can_collide_with_stone(){
        ball.setxVelocity(1);
        ball.setyVelocity(1);

        for(int i = 0; i < 20 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                stone.collideWithBall(ball);
                break;
            }
        }
        for(int i = 0; i < 10; i++){
            ball.move();
        }
        assertEquals(2, ball.getyPosition(), 0.0001);
    }
}
