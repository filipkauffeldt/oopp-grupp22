package com.crocket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoneTest {
    private Ball ball = new Ball(20, 20, 0, 0, 2);
    private Stone stone = new Stone(25, 25, 20, 30);
    
    @Before
    public void reset_ball(){
        ball = new Ball(20, 20, 0, 20, 2);
    }

    @Test
    public void test_if_collision_works_from_up(){
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        while(!CollisionHandler.intersect(ball, stone)){

            ball.move();
        }
        // stone.collideWithBall(ball);
        // for(int i = 0; i < 10; i++){
        //     ball.move();
        // }
        assertEquals(ball.getyPosition(), 20, 0.0001);
    }
}
