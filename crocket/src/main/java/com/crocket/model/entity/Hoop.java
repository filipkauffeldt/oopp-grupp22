package com.crocket.model.entity;

import com.crocket.model.EventPublisher;
import com.crocket.model.PassTargetEvent;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.shared.Direction;
import static com.crocket.shared.Direction.*;

public class Hoop extends Entity implements ICollidable {
    private int innerWidth;
    private int innerHeight;
    private Direction dir;

    private Hitbox innerHitbox;
    private Hitbox leftHitbox;
    private Hitbox rightHitbox;

    private EventPublisher eventPublisher;

    public Hoop(int width, int height, int openingWidth, int openingHeight, double xPosition, double yPosition, Direction dir) {
        super(width, height, xPosition, yPosition);
        this.innerWidth = openingWidth;
        this.innerHeight= openingHeight;
        this.dir = dir;
        
        this.innerHitbox = createScoreHitbox();
        this.eventPublisher = EventPublisher.getInstance();
        createPostsHitbox();
    }

    @Override
    public void collideWithBall(Ball ball) {
        if (missedTarget(ball)) return;
        if (collidedLeft(ball)) {
            Direction direction = CollisionHandler.collidedDirection(ball, leftHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (collidedRight(ball)) {
            Direction direction = CollisionHandler.collidedDirection(ball, rightHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (passedThrough(ball)) {
            PassTargetEvent event = new PassTargetEvent(ball, this);
            eventPublisher.publishEvent(event);
        }
    }



    private void createPostsHitbox() {
    if (this.dir == EAST || this.dir == WEST) {
        createHorizontalPostsHitbox();
    } else {
        createVerticalPostsHitbox();
    }
}

    private void createHorizontalPostsHitbox() {
        int hitboxWidth = 3;
        int hitboxHeight = (this.getHeight() - this.innerWidth) / 2;
        double xHitboxPlacement = this.getWidth() / 2 - hitboxWidth + this.getxPosition();
        double yTopHitboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
        double yBottomHitboxPlacement = this.getyPosition();

        this.leftHitbox = new Hitbox(hitboxWidth, hitboxHeight, xHitboxPlacement, yTopHitboxPlacement);
        this.rightHitbox = new Hitbox(hitboxWidth, hitboxHeight, xHitboxPlacement, yBottomHitboxPlacement);
    }

    private void createVerticalPostsHitbox() {
        int hitboxWidth = (this.getWidth() - this.innerWidth) / 2;
        int hitboxHeight = 3;
        double xLeftHitboxPlacement = hitboxWidth + this.getxPosition();
        double xRightHitboxPlacement = this.getWidth() - hitboxWidth + this.getxPosition();
        double yHitboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();

        this.leftHitbox = new Hitbox(hitboxWidth, hitboxHeight, xLeftHitboxPlacement, yHitboxPlacement);
        this.rightHitbox = new Hitbox(hitboxWidth, hitboxHeight, xRightHitboxPlacement, yHitboxPlacement);
    }

    //Todo: Make this better. 
    private Hitbox createScoreHitbox() {
        double xRelativeHitboxPlacement;
        double yRelativeHitboxPlacement;
        int hitboxWidth;
        int hitboxHeight;
    
        boolean isEastOrWest = this.dir == EAST || this.dir == WEST;
        xRelativeHitboxPlacement = isEastOrWest ? this.getWidth() / 2 : (this.getWidth() - this.innerWidth) / 2;
        yRelativeHitboxPlacement = isEastOrWest ? (this.getHeight() - this.innerWidth) / 2 : this.getHeight() - this.innerHeight;
        hitboxWidth = isEastOrWest ? this.innerHeight : this.innerWidth;
        hitboxHeight = isEastOrWest ? this.innerWidth : this.innerHeight;
    
        return new Hitbox(hitboxWidth, hitboxHeight, xRelativeHitboxPlacement + this.getxPosition(), yRelativeHitboxPlacement + this.getyPosition());
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
        return CollisionHandler.intersect(ball, leftHitbox);
    }
}