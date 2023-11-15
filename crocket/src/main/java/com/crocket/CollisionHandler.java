package com.crocket;

import java.lang.Math;

public class CollisionHandler {
    public static boolean intersect(Entity entity1, Entity entity2)  {
        Hitbox e1Hitbox = entity1.getHitbox();
        Hitbox e2Hitbox = entity2.getHitbox();

        return intersect(e1Hitbox, e2Hitbox);
    }

    public static boolean intersect(Entity entity, Hitbox hitbox) {
        Hitbox eHitbox = entity.getHitbox();

        return intersect(eHitbox, hitbox);
    }

    public static boolean intersect(Hitbox hitbox1, Hitbox hitbox2) {
        double h1X = hitbox1.getxPosition();
        double h1Y = hitbox1.getyPosition();
        int h1Width = hitbox1.getWidth();
        int h1Height = hitbox1.getHeight();

        double h2X = hitbox2.getxPosition();
        double h2Y = hitbox2.getyPosition();
        int h2Width = hitbox2.getWidth();
        int h2Height = hitbox2.getHeight();

        boolean isLeft = h1X < h2X + h2Width;
        boolean isRight = h1X + h1Width > h2X;
        boolean isAbove = h1Y < h2Y + h2Height;
        boolean isBelow = h1Y + h1Height > h2Y;

        return (isLeft &&
                isRight &&
                isAbove &&
                isBelow);
    }

    public static void reflect(IMovable entity, Direction direction) {
        double xVelocity = entity.getxVelocity();
        double yVelocity = entity.getyVelocity();

        if (direction == Direction.EAST || direction == Direction.WEST) {
            entity.setxVelocity(-xVelocity);
        } else {
            entity.setyVelocity(-yVelocity);
        }
    }

    public static Direction collidedDirection(Entity entity1, Entity entity2) {
        Hitbox e1Hitbox = entity1.getHitbox();
        Hitbox e2Hitbox = entity2.getHitbox();

        double e1X = e1Hitbox.getxPosition();
        double e1Y = e1Hitbox.getyPosition();

        double e2X = e2Hitbox.getxPosition();
        double e2Y = e2Hitbox.getyPosition();

        if (intersect(entity1, entity2)) {
            double xDistance = e1X - e2X;
            double yDistance = e1Y - e2Y;

            if (Math.abs(xDistance) > Math.abs(yDistance)) {
                if (xDistance > 0) {
                    return Direction.EAST;
                } else {
                    return Direction.WEST;
                }
            } else {
                if (yDistance > 0) {
                    return Direction.SOUTH;
                } else {
                    return Direction.NORTH;
                }
            }
        } else {
            throw new IllegalArgumentException("Entities do not intersect");
        }
    }

    public static Direction collidedDirection(Entity entity, Hitbox hitbox) {
        Hitbox eHitbox = entity.getHitbox();

        double eX = eHitbox.getxPosition();
        double eY = eHitbox.getyPosition();

        double hX = hitbox.getxPosition();
        double hY = hitbox.getyPosition();

        if (intersect(entity, hitbox)) {
            double xDistance = eX - hX;
            double yDistance = eY - hY;

            if (Math.abs(xDistance) > Math.abs(yDistance)) {
                if (xDistance > 0) {
                    return Direction.EAST;
                } else {
                    return Direction.WEST;
                }
            } else {
                if (yDistance > 0) {
                    return Direction.SOUTH;
                } else {
                    return Direction.NORTH;
                }
            }
        } else {
            throw new IllegalArgumentException("Entities do not intersect");
        }
    }

    public static Direction collidedDirection(Hitbox hitbox1, Hitbox hitbox2) {
        double h1X = hitbox1.getxPosition();
        double h1Y = hitbox1.getyPosition();

        double h2X = hitbox2.getxPosition();
        double h2Y = hitbox2.getyPosition();

        if (intersect(hitbox1, hitbox2)) {
            double xDistance = h1X - h2X;
            double yDistance = h1Y - h2Y;

            if (Math.abs(xDistance) > Math.abs(yDistance)) {
                if (xDistance > 0) {
                    return Direction.EAST;
                } else {
                    return Direction.WEST;
                }
            } else {
                if (yDistance > 0) {
                    return Direction.SOUTH;
                } else {
                    return Direction.NORTH;
                }
            }
        } else {
            throw new IllegalArgumentException("Entities do not intersect");
        }
    }

    // public static void elasticCollision(Entity entity1, Entity entity2){
    //     //Normal or distance between center of both objects. 
    //     double dx = entity1.getxPosition() - entity2.getxPosition();
    //     double dy = entity1.getyPosition() - entity2.getyPosition();

    //     //Normalise the normal vector 
    //     double magnitude = Math.sqrt(dx * dx + dy * dy);
    //     double unitNormalX = dx / magnitude;
    //     double unitNormalY = dy / magnitude;
    //     double unitTangentX = -unitNormalY;
    //     double unitTangentY = unitNormalX;

    //     //Project the normal
    //     double v1n = unitNormalX * entity1.getxVelocity() + unitNormalY * entity1.getyVelocity();
    //     double v2n = unitNormalX * entity2.getxVelocity() + unitNormalY * entity2.getyVelocity();

    //     double v1t = unitTangentX * entity1.getxVelocity() + unitTangentY * entity1.getyVelocity();
    //     double v2t = unitTangentX * entity2.getxVelocity() + unitTangentY * entity2.getyVelocity();

    //     double mass1 = entity1.getMass();
    //     double mass2 = entity2.getMass();

    //     //Normal velocities with the one-dimensional collision formula
    //     double newV1n = (v1n * (mass1 - mass2) + 2 * mass2 * v2n)/(mass1 + mass2);
    //     double newV2n = (v2n * (mass2 - mass1) + 2 * mass1 * v1n)/(mass1 + mass2);

    //     //Converts the scalar normal and tangential velocities into vectors 
    //     //And makes final velocity vectors by adding the normal and tangential components.
    //     double newXVelocityEntity1 = (newV1n * unitNormalX) + (v1t * unitTangentX);
    //     double newXVelocityEntity2 = (newV2n * unitNormalX) + (v2t * unitTangentX);
    //     double newYVelocityEntity1 = (newV1n * unitNormalY) + (v1t * unitTangentY);
    //     double newYVelocityEntity2 = (newV2n * unitNormalY) + (v2t * unitTangentY);

    //     entity1.setxVelocity(newXVelocityEntity1);
    //     entity1.setyVelocity(newYVelocityEntity1);

    //     entity2.setxVelocity(newXVelocityEntity2);
    //     entity2.setyVelocity(newYVelocityEntity2);  
    // }
}
