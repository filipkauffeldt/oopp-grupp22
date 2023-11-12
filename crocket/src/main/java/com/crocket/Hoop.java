package com.crocket;

public class Hoop extends Entity implements ICollidable {
    private int innerWidth;
    private Direction dir;

    private Hitbox innerHitbox;
    private Hitbox lefHitbox;
    private Hitbox rightHitbox;

    public Hoop(int width, int height, int innerWidth, double xPosition, double yPosition, Direction dir) {
        super(width, height, xPosition, yPosition);
        this.innerWidth = innerWidth;
        this.dir = dir;
        this.innerHitbox = createInnerHitbox(width, height, innerWidth, dir, xPosition, yPosition);

        int sideWidth = (width - innerWidth)/2;
        this.lefHitbox = new Hitbox(sideWidth, height, xPosition, yPosition); // Probably not right. Does not take into account rotation
    }

    @Override
    public void collideWithBall(Ball ball) {
        if (collidedLeft(ball)) {
            
        } else if (collidedRight(ball)) {
            
        } else if (passedThrough(ball)) {
            // Notify player that they passed the hoop
            // Move ball outside hoopp?
        }
    }

    private Hitbox createInnerHitbox(int outerWidth, int height, int innerWidth, Direction direction, double xPosition, double yPosition) {
        if (direction == Direction.EAST || direction == Direction.WEST) {
            double xStart = xPosition + (outerWidth - innerWidth)/2;
            return new Hitbox(innerWidth, innerWidth/10, xStart, yPosition);
        } else {
            double yStart = yPosition + (outerWidth - innerWidth)/2;
            return new Hitbox(innerWidth/10, innerWidth, xPosition, yStart);
        }
    }

    private boolean passedThrough(Ball ball) {
        return false;
    }

    private boolean collidedRight(Ball ball) {
        return false;
    }

    private boolean collidedLeft(Ball ball) {
        return false;
    }
}