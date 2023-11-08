/*package com.crocket;
import java.lang.Math;

public class CollisionHandler {
    public static void elasticCollision(Entity entity1, Entity entity2){
        //Normal or distance between center of both objects. 
        double dx = entity1.getxPosition() - entity2.getxPosition();
        double dy = entity1.getyPosition() - entity2.getyPosition();

        //Normalise the normal vector 
        double magnitude = Math.sqrt(dx * dx + dy * dy);
        double unitNormalX = dx / magnitude;
        double unitNormalY = dy / magnitude;
        double unitTangentX = -unitNormalY;
        double unitTangentY = unitNormalX;

        //Project the normal
        double v1n = unitNormalX * entity1.getxVelocity() + unitNormalY * entity1.getyVelocity();
        double v2n = unitNormalX * entity2.getxVelocity() + unitNormalY * entity2.getyVelocity();

        double v1t = unitTangentX * entity1.getxVelocity() + unitTangentY * entity1.getyVelocity();
        double v2t = unitTangentX * entity2.getxVelocity() + unitTangentY * entity2.getyVelocity();

        double mass1 = entity1.getMass();
        double mass2 = entity2.getMass();

        //Normal velocities with the one-dimensional collision formula
        double newV1n = (v1n * (mass1 - mass2) + 2 * mass2 * v2n)/(mass1 + mass2);
        double newV2n = (v2n * (mass2 - mass1) + 2 * mass1 * v1n)/(mass1 + mass2);

        //Converts the scalar normal and tangential velocities into vectors 
        //And makes final velocity vectors by adding the normal and tangential components.
        double newXVelocityEntity1 = (newV1n * unitNormalX) + (v1t * unitTangentX);
        double newXVelocityEntity2 = (newV2n * unitNormalX) + (v2t * unitTangentX);
        double newYVelocityEntity1 = (newV1n * unitNormalY) + (v1t * unitTangentY);
        double newYVelocityEntity2 = (newV2n * unitNormalY) + (v2t * unitTangentY);

        entity1.setxVelocity(newXVelocityEntity1);
        entity1.setyVelocity(newYVelocityEntity1);

        entity2.setxVelocity(newXVelocityEntity2);
        entity2.setyVelocity(newYVelocityEntity2);  
    }
}*/
