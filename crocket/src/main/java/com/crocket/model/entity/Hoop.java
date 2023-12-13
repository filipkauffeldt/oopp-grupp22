package com.crocket.model.entity;

import com.crocket.model.EventPublisher;
import com.crocket.model.PassTargetEvent;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.IEntityVisitor;
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

    public Hoop(int width, int height, int openingWidth, int openingHeight, double xPosition, double yPosition,
            Direction dir) {
        super(width, height, xPosition, yPosition);
        this.innerWidth = openingWidth;
        this.innerHeight = openingHeight;
        this.dir = dir;

        createHoopHitboxes();
        this.eventPublisher = EventPublisher.getInstance();
    }

    @Override
    public void collideWithBall(Ball ball) {
        if (missedTarget(ball))
            return;
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

    private void createHoopHitboxes() {
        if (this.dir == EAST || this.dir == WEST) {
            createVerticalScoreHitbox();
            createVerticalPostsHitbox();
        } else {
            createHorizontalPostsHitbox();
            createHorizontalScoreHitbox();
        }
    }

    private void createHorizontalPostsHitbox() {
        int hitboxWidth = (this.getWidth() - this.innerWidth) / 2;
        int hitboxHeight = this.innerHeight;
        double xLeftHitboxPlacement = this.getxPosition();
        double xRightHitboxPlacement = this.getWidth() - hitboxWidth + this.getxPosition();
        double yHitboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
        this.leftHitbox = new Hitbox(hitboxWidth, hitboxHeight, xLeftHitboxPlacement, yHitboxPlacement);
        this.rightHitbox = new Hitbox(hitboxWidth, hitboxHeight, xRightHitboxPlacement, yHitboxPlacement);
    }

    private void createVerticalPostsHitbox() {
        int hitboxWidth = this.innerHeight;
        int hitboxHeight = (this.getWidth() - this.innerWidth) / 2;
        double xHitboxPlacement = this.getWidth() / 2 - hitboxWidth + this.getxPosition();
        double yTopHitboxPlacement = this.getyPosition();
        double yBottomHitboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
        this.leftHitbox = new Hitbox(hitboxWidth, hitboxHeight, xHitboxPlacement, yTopHitboxPlacement);
        this.rightHitbox = new Hitbox(hitboxWidth, hitboxHeight, xHitboxPlacement, yBottomHitboxPlacement);
    }

    private void createHorizontalScoreHitbox() {
        double xHitboxPlacement = (this.getWidth() - this.innerWidth) / 2 + this.getxPosition();
        double yHitboxPlacement = this.getHeight() - this.innerHeight + this.getyPosition();
        this.innerHitbox = new Hitbox(this.innerWidth, this.innerHeight, xHitboxPlacement, yHitboxPlacement);
    }

    private void createVerticalScoreHitbox() {
        double xHitboxPlacement = this.getWidth() / 2 - this.innerWidth + this.getxPosition();
        double yHitboxPlacement = this.getHeight() - this.innerHeight + this.getyPosition();
        this.innerHitbox = new Hitbox(this.innerWidth, this.innerHeight, xHitboxPlacement, yHitboxPlacement);
    }

    private boolean missedTarget(Ball ball) {
        return !CollisionHandler.intersect(ball, this);
    }

    private boolean collidedLeft(Ball ball) {
        return CollisionHandler.intersect(ball, leftHitbox);
    }

    private boolean collidedRight(Ball ball) {
        return CollisionHandler.intersect(ball, rightHitbox);
    }

    private boolean passedThrough(Ball ball) {
        return CollisionHandler.intersect(ball, innerHitbox) 
            && (CollisionHandler.northSouthCollisionDirection(ball) == this.dir
                || CollisionHandler.eastWestCollisionDirection(ball) == this.dir);
    }

    public Hitbox getLeftHitbox() {
        return new Hitbox(leftHitbox.getWidth(), leftHitbox.getHeight(), leftHitbox.getxPosition(), leftHitbox.getyPosition());
    }

    public Hitbox getRightHitbox() {
        return new Hitbox(rightHitbox.getWidth(), rightHitbox.getHeight(), rightHitbox.getxPosition(),rightHitbox.getyPosition());
    }

    public Direction getDirection() {
        return this.dir;
    }

    // Weird bug should work in entity but IEntityVisitor does not use the overloaded method
    @Override 
    public void accept(IEntityVisitor visitor) {
        visitor.visit(this);
    }
}