package com.crocket;

public class Hoop extends Entity implements ICollidable {
    private int innerWidth;
    private Direction dir;

    private Hitbox innerHitbox;
    private Hitbox lefHitbox;
    private Hitbox rightHitbox;

    public Hoop(int width, int height, int openingWidth, double xPosition, double yPosition, Direction dir) {
        super(width, height, xPosition, yPosition);
        this.innerWidth = openingWidth;
        this.dir = dir;
        this.innerHitbox = createInnerHitbox(width, height, openingWidth, dir, xPosition, yPosition);

        int sideWidth = (width - openingWidth)/2;
        this.lefHitbox = new Hitbox(sideWidth, height, xPosition, yPosition); // Probably not right. Does not take into account rotation
    }

    @Override
    public void collideWithBall(Ball ball) {
        if (missedTarget(ball)) return;
        if (collidedLeft(ball)) {
            Direction direction = CollisionHandler.collidedDirection(ball, lefHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (collidedRight(ball)) {
            Direction direction = CollisionHandler.collidedDirection(ball, rightHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (passedThrough(ball)) {
            // TODO: Implement when possible in user
            // Notify player that they passed the hoop
            // Move ball outside hoop?
        }
    }

    private Hitbox createInnerHitbox(int outerWidth, int height, int innerWidth, Direction direction, double xPosition, double yPosition) {
        if (direction == Direction.EAST || direction == Direction.WEST) {
            double yStart = yPosition + (outerWidth - innerWidth)/2;
            return new Hitbox(innerWidth/10, innerWidth, xPosition, yStart);
        } else {
            double xStart = xPosition + (outerWidth - innerWidth)/2;
            return new Hitbox(innerWidth, innerWidth/10, xStart, yPosition);
        }
    }

    private boolean missedTarget(Ball ball) {
        return !CollisionHandler.intersect(ball, this);
    }

    private boolean passedThrough(Ball ball) {
        return CollisionHandler.intersect(ball, innerHitbox);

    }

    private boolean collidedRight(Ball ball) {
        return CollisionHandler.intersect(ball, rightHitbox);
    }

    private boolean collidedLeft(Ball ball) {
        return CollisionHandler.intersect(ball, lefHitbox);
    }
}