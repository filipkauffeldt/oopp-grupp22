package com.crocket;

public class Stone extends Obstacle {

    Stone(int width, int height, double xPosition, double yPosition) {
        super(width, height, xPosition, yPosition);
    }

    public void collideWithBall(Ball ball){
        if (collideTarget(ball)){
            Direction direction = collisionDirection(ball);
            reflectEntity(ball, direction);
        }
    }

    private boolean collideTarget(Ball ball){
        return CollisionHandler.intersect(ball, this.getHitbox());
    }

    private Direction collisionDirection(Ball ball){
        return CollisionHandler.collidedDirection(ball, this.getHitbox());
    }

    private void reflectEntity(Ball ball, Direction direction){
        CollisionHandler.reflect(ball, direction);
    }
}
