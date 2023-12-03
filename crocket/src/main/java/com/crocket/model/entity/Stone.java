package com.crocket.model.entity;

import com.crocket.shared.Direction;

public class Stone extends Obstacle {

    public Stone(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
    }

    public void collideWithBall(Ball ball){
        if (collideTarget(ball)){
            Direction direction = collisionDirection(ball);
            reflectEntity(ball, direction);
        }
    }

    private boolean collideTarget(Ball ball){
        Hitbox stoneHitbox = this.getHitbox();
        return CollisionHandler.intersect(ball, stoneHitbox);
    }

    private Direction collisionDirection(Ball ball){
        Hitbox stoneHitbox = this.getHitbox();
        return CollisionHandler.collidedDirection(ball, stoneHitbox);
    }

    private void reflectEntity(Ball ball, Direction direction){
        CollisionHandler.reflect(ball, direction);
    }
}
