package com.crocket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollisionHandlerTest {

    private Ball ball = new Ball(20, 20, 0, 0, 2);
    private Stone stone = new Stone(25, 25, 30, 30);
    
    @Test
    public void test_if_collision_works_from_up() {
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        Hitbox ballHitbox = ball.getHitbox();
        boolean collision = false;
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                collision = true;
                break;
            }
        }

        System.out.println(ballHitbox.getyPosition());
        System.out.println(ball.getyPosition() + ball.getHeight());

        System.out.println(stone.getyPosition());
        System.out.println(stone.getyPosition() + stone.getHeight());
        assertEquals(collision, true);
    }

}
