package com.crocket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollisionHandlerTest {

    private Ball ball = new Ball(20, 20, 0, 0, 2);
    private Stone stone = new Stone(25, 25, 10, 30);
    
    @Test
    public void test_if_collision_works_from_up() {
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        Direction directionCollision = Direction.SOUTH;
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                directionCollision = CollisionHandler.collidedDirection(ball, stone);
                break;
            }
        }
        assertEquals(directionCollision, Direction.NORTH);
    }

    @Test
    public void test_if_collision_works_from_left() {
        ball.setxPosition(-30);
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        Direction directionCollision = Direction.SOUTH;
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                directionCollision = CollisionHandler.collidedDirection(ball, stone);
                break;
            }
        }
        assertEquals(directionCollision, Direction.WEST);
    }

    @Test
    public void test_if_collision_works_from_right() {
        ball.setxPosition(70);
        ball.setxVelocity(-1);
        ball.setyVelocity(1);
        Direction directionCollision = Direction.SOUTH;
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                directionCollision = CollisionHandler.collidedDirection(ball, stone);
                break;
            }
        }
        assertEquals(directionCollision, Direction.EAST);
    }

    @Test
    public void test_if_collision_works_from_below() {
        ball.setxPosition(0);
        ball.setyPosition(60);
        ball.setxVelocity(1);
        ball.setyVelocity(-1);
        Direction directionCollision = Direction.NORTH;
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                directionCollision = CollisionHandler.collidedDirection(ball, stone);
                break;
            }
        }
        assertEquals(directionCollision, Direction.SOUTH);
    }

    @Test
    public void test_if_reflection_works_from_up() {
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                Direction directionCollision = CollisionHandler.collidedDirection(ball, stone);
                CollisionHandler.reflect(ball, directionCollision);
                break;
            }
        }
        assertEquals(-1, ball.getyVelocity(), 0.1);
    }

    @Test
    public void test_if_reflection_works_from_left() {
        ball.setxPosition(-30);
        ball.setxVelocity(1);
        ball.setyVelocity(1);
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                Direction directionCollision = CollisionHandler.collidedDirection(ball, stone);
                CollisionHandler.reflect(ball, directionCollision);
                break;
            }
        }
        assertEquals(-1, ball.getxVelocity(), 0.1);
    }

    @Test
    public void test_if_reflection_works_from_right(){
        ball.setxPosition(70);
        ball.setxVelocity(-1);
        ball.setyVelocity(1);

        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                Direction directionCollision = CollisionHandler.collidedDirection(ball, stone);
                CollisionHandler.reflect(ball, directionCollision);
                break;
            }
        }
        assertEquals(1, ball.getxVelocity(), 0.1);
    }
    @Test
    public void test_if_reflection_works_from_bottom(){
        ball.setxPosition(0);
        ball.setyPosition(60);
        ball.setxVelocity(1);
        ball.setyVelocity(-1);
        for(int i = 0; i < 100 ; i++){
            ball.move();
            if(CollisionHandler.intersect(ball, stone)){
                Direction directionCollision = CollisionHandler.collidedDirection(ball, stone);
                CollisionHandler.reflect(ball, directionCollision);
                break;
            }
        }
        assertEquals(1, ball.getyVelocity(), 0.1);
    }

}
