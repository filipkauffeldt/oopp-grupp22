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
        this.innerHitbox = createInnerHitbox(width, height, openingWidth, openingHeight, dir, xPosition, yPosition);

        int sideWidth = (width - openingWidth)/2;
        this.lefHitbox = new Hitbox(sideWidth, height, xPosition, yPosition); // Probably not right. Does not take into account rotation
        this.rightHitbox = new Hitbox(sideWidth, height, xPosition + sideWidth + openingWidth, yPosition); // Probably not right. Does not take into account rotation

        this.eventPublisher = EventPublisher.getInstance();
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

    //Todo: Make this better. 
    private Hitbox createScorehitbox(){
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
        return(new Hitbox(hitboxWidht,hitboxHeight,xRealativeHitboxPlacement, yRealativeHitxboxPlacement));

    }


  private Hitbox createInnerHitbox(int outerWidth, int height, int innerWidth, int openingHeight, Direction direction, double xPosition, double yPosition) {
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