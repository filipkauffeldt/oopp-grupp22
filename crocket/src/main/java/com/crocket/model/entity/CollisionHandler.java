package com.crocket.model.entity;

import java.lang.Math;

import com.crocket.model.interfaces.IMovable;
import com.crocket.shared.Direction;

class CollisionHandler {

    public static boolean intersect(Entity entity1, Entity entity2) {
        Hitbox e1Hitbox = entity1.getHitbox();
        Hitbox e2Hitbox = entity2.getHitbox();

        return intersect(e1Hitbox, e2Hitbox);
    }

    static boolean intersect(Entity entity, Hitbox hitbox) {
        Hitbox eHitbox = entity.getHitbox();

        return intersect(eHitbox, hitbox);
    }

    static boolean intersect(Hitbox hitbox1, Hitbox hitbox2) {
        double h1X = hitbox1.getxPosition();
        double h1Y = hitbox1.getyPosition();
        int h1Width = hitbox1.getWidth();
        int h1Height = hitbox1.getHeight();

        double h2X = hitbox2.getxPosition();
        double h2Y = hitbox2.getyPosition();
        int h2Width = hitbox2.getWidth();
        int h2Height = hitbox2.getHeight();

        return (h1X + h1Width > h2X &&
                h1Y + h1Height > h2Y &&
                h1X < h2X + h2Width &&
                h1Y < h2Y + h2Height);

        /*
         * boolean xMax1IsGreaterThanxPos2 = h1X + h1Width > h2X;
         * boolean xMax1IsLesserThanxMax2 = h1X + h1Width < h2X + h2Width;
         * boolean xMin1IsGreaterThanxPos2 = h1X > h2X;
         * boolean xMin1IsLesserThanxMax2 = h1X < h2X + h2Width;
         * boolean yMax1IsGreaterThanyPos2 = h1Y + h1Height > h2Y;
         * boolean yMax1IsLesserThanyMax2 = h1Y + h1Height < h2Y + h2Height;
         * boolean yMin1IsLesserThanyMax2 = h1Y < h2Y + h2Height;
         * boolean yMin1IsGreaterThanyPos2 = h1Y > h2Y;
         * 
         * boolean xMaxIsBetween = xMax1IsGreaterThanxPos2 && xMax1IsLesserThanxMax2;
         * boolean xMinIsBetween = xMin1IsGreaterThanxPos2 && xMin1IsLesserThanxMax2;
         * boolean yMaxIsBetween = yMax1IsGreaterThanyPos2 && yMax1IsLesserThanyMax2;
         * boolean yMinIsBetween = yMin1IsGreaterThanyPos2 && yMin1IsLesserThanyMax2;
         * 
         * boolean yMaxIsBetweenIntervalAbove = yMax1IsGreaterThanyPos2 &&
         * yMax1IsLesserThanyMax2;
         * boolean xMaxIsBetweenIntervalLeft = xMax1IsGreaterThanxPos2 &&
         * xMax1IsLesserThanxMax2;
         * boolean yMinIsBetweenIntervalBelow = yMin1IsLesserThanyMax2 &&
         * yMin1IsGreaterThanyPos2;
         * boolean xMinIsBetweenIntervalRight = xMin1IsLesserThanxMax2 &&
         * xMin1IsGreaterThanxPos2;
         * 
         * boolean intervalXAxis = xMaxIsBetween || xMinIsBetween;
         * boolean intervalYAxis = yMaxIsBetween || yMinIsBetween;
         * 
         * boolean intersectFromAbove = intervalXAxis && yMaxIsBetweenIntervalAbove;
         * boolean intersectFromBelow = intervalXAxis && yMinIsBetweenIntervalBelow;
         * boolean intersectFromLeft = intervalYAxis && xMaxIsBetweenIntervalLeft;
         * boolean intersectFromRight = intervalYAxis && xMinIsBetweenIntervalRight;
         * 
         * if (intersectFromAbove) {
         * return true;
         * }
         * 
         * if (intersectFromBelow) {
         * return true;
         * }
         * 
         * if (intersectFromLeft) {
         * return true;
         * }
         * 
         * if (intersectFromRight) {
         * return true;
         * }
         * 
         * return false;
         */
    }

    static void reflect(IMovable entity, Direction direction) {
        double xVelocity = entity.getxVelocity();
        double yVelocity = entity.getyVelocity();

        if (direction == Direction.EAST || direction == Direction.WEST) {
            entity.setxVelocity(-xVelocity);
        } else {
            entity.setyVelocity(-yVelocity);
        }
    }
    
    private static double getXDistance(Hitbox hitbox1, Hitbox hitbox2) {
        double h1X = hitbox1.getxPosition();
        double h2X = hitbox2.getxPosition();

        return h1X - h2X;
    }

    private static double getYDistance(Hitbox hitbox1, Hitbox hitbox2) {
        double h1Y = hitbox1.getyPosition();
        double h2Y = hitbox2.getyPosition();

        return h1Y - h2Y;
    }

    static Direction collidedDirection(Entity entity1, Entity entity2) {
        Hitbox e1Hitbox = entity1.getHitbox();
        Hitbox e2Hitbox = entity2.getHitbox();

        return collidedDirection(e1Hitbox, e2Hitbox);
    }

    static Direction collidedDirection(Entity entity1, Hitbox hitbox) {
        Hitbox e1Hitbox = entity1.getHitbox();
        return collidedDirection(e1Hitbox, hitbox);
    }

    static Direction collidedDirection(Hitbox hitbox1, Hitbox hitbox2) {
        if (!intersect(hitbox1, hitbox2)) {
            throw new IllegalArgumentException("Entities do not intersect");
        }

        double xDistance = getXDistance(hitbox1, hitbox2);
        double yDistance = getYDistance(hitbox1, hitbox2);

        if (Math.abs(xDistance) > Math.abs(yDistance)) {
            return xDistance > 0 ? Direction.EAST : Direction.WEST;
        } else {
            return yDistance > 0 ? Direction.SOUTH : Direction.NORTH;
        }
    }

    static Direction northSouthCollisionDirection(Entity entity) {
        Hitbox eHitbox = entity.getHitbox();

        double eY = eHitbox.getyPosition();
        double ePrevY = entity.getPrevYPosition();
        if (eY - ePrevY == 0) {
            return Direction.NONE;
        } else if (eY > ePrevY) {
            return Direction.NORTH;
        } else {
            return Direction.SOUTH;
        }
    }

    static Direction eastWestCollisionDirection(Entity entity) {
        Hitbox eHitbox = entity.getHitbox();

        double eX = eHitbox.getxPosition();
        double ePrevX = entity.getPrevXPosition();
        if (eX - ePrevX == 0) {
            return Direction.NONE;
        } else if (eX > ePrevX) {
            return Direction.EAST;
        } else {
            return Direction.WEST;
        }
    }

    // public static void elasticCollision(Entity entity1, Entity entity2){
    // //Normal or distance between center of both objects.
    // double dx = entity1.getxPosition() - entity2.getxPosition();
    // double dy = entity1.getyPosition() - entity2.getyPosition();

    // //Normalise the normal vector
    // double magnitude = Math.sqrt(dx * dx + dy * dy);
    // double unitNormalX = dx / magnitude;
    // double unitNormalY = dy / magnitude;
    // double unitTangentX = -unitNormalY;
    // double unitTangentY = unitNormalX;

    // //Project the normal
    // double v1n = unitNormalX * entity1.getxVelocity() + unitNormalY *
    // entity1.getyVelocity();
    // double v2n = unitNormalX * entity2.getxVelocity() + unitNormalY *
    // entity2.getyVelocity();

    // double v1t = unitTangentX * entity1.getxVelocity() + unitTangentY *
    // entity1.getyVelocity();
    // double v2t = unitTangentX * entity2.getxVelocity() + unitTangentY *
    // entity2.getyVelocity();

    // double mass1 = entity1.getMass();
    // double mass2 = entity2.getMass();

    // //Normal velocities with the one-dimensional collision formula
    // double newV1n = (v1n * (mass1 - mass2) + 2 * mass2 * v2n)/(mass1 + mass2);
    // double newV2n = (v2n * (mass2 - mass1) + 2 * mass1 * v1n)/(mass1 + mass2);

    // //Converts the scalar normal and tangential velocities into vectors
    // //And makes final velocity vectors by adding the normal and tangential
    // components.
    // double newXVelocityEntity1 = (newV1n * unitNormalX) + (v1t * unitTangentX);
    // double newXVelocityEntity2 = (newV2n * unitNormalX) + (v2t * unitTangentX);
    // double newYVelocityEntity1 = (newV1n * unitNormalY) + (v1t * unitTangentY);
    // double newYVelocityEntity2 = (newV2n * unitNormalY) + (v2t * unitTangentY);

    // entity1.setxVelocity(newXVelocityEntity1);
    // entity1.setyVelocity(newYVelocityEntity1);

    // entity2.setxVelocity(newXVelocityEntity2);
    // entity2.setyVelocity(newYVelocityEntity2);
    // }

}
