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
    private Hitbox lefHitbox;
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
            Direction direction = CollisionHandler.collidedDirection(ball, lefHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (collidedRight(ball)) {
            Direction direction = CollisionHandler.collidedDirection(ball, rightHitbox);
            CollisionHandler.reflect(ball, direction);
        } else if (passedThrough(ball)) {
            PassTargetEvent event = new PassTargetEvent(ball, this);
            eventPublisher.publishEvent(event);
        }
    }

    //Makes the posts hitbox for the goal.
    private void createPostsHitbox(){
        int hitboxWidth;
        int hitboxHeight;
        double xRealativeLeftHitboxPlacement;
        double yRealativeLeftHitxboxPlacement;
        double xRealativeRightHitboxPlacement;
        double yRealativeRightHitxboxPlacement;
        if(this.dir == EAST || this.dir == WEST){
            hitboxWidth = 3;
            hitboxHeight = (this.getHeight() - this.innerWidth)/2;
            xRealativeLeftHitboxPlacement = this.getWidth()/2 - hitboxWidth + this.getxPosition();
            xRealativeRightHitboxPlacement = this.getWidth()/2 - hitboxWidth + this.getxPosition(); 
            yRealativeLeftHitxboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
            yRealativeRightHitxboxPlacement = this.getyPosition();
        } else {
            hitboxHeight = 3;
            hitboxWidth = (this.getWidth() - this.innerWidth)/2;
            xRealativeLeftHitboxPlacement = hitboxWidth + this.getxPosition();
            xRealativeRightHitboxPlacement = this.getWidth() - hitboxWidth + this.getxPosition();
            yRealativeLeftHitxboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
            yRealativeRightHitxboxPlacement = this.getHeight() - hitboxHeight + this.getyPosition();
        }
            this.lefHitbox = new Hitbox(hitboxWidth, hitboxHeight, xRealativeLeftHitboxPlacement, yRealativeLeftHitxboxPlacement);
            this.rightHitbox = new Hitbox(hitboxWidth, hitboxHeight, xRealativeRightHitboxPlacement, yRealativeRightHitxboxPlacement);
    }

    //Todo: Make this better. 
    private Hitbox createScoreHitbox(){
        double xRealativeHitboxPlacement;
        double yRealativeHitxboxPlacement;
        int hitboxWidht;
        int hitboxHeight;
        if( this.dir == EAST || this.dir == WEST){
            xRealativeHitboxPlacement = this.getWidth()/2;  //Might be weird but from above we do not need 
            yRealativeHitxboxPlacement = (this.getHeight() - this.innerWidth)/2;
            hitboxWidht = this.innerHeight;
            hitboxHeight = this.innerWidth;
            
        } else {
            xRealativeHitboxPlacement = (this.getWidth() - this.innerWidth)/2;
            yRealativeHitxboxPlacement = this.getHeight() - this.innerHeight;
            hitboxWidht = this.innerWidth;
            hitboxHeight = this.innerHeight;
        }
        return(new Hitbox(hitboxWidht,hitboxHeight,xRealativeHitboxPlacement + this.getxPosition(), yRealativeHitxboxPlacement + this.getyPosition()));

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