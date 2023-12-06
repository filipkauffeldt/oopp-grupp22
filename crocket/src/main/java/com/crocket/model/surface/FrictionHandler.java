package com.crocket.model.surface;
import com.crocket.model.entity.Ball;
import com.crocket.model.DirectionLine;

public class FrictionHandler {
    public void handleFriction(Ball ball, DirectionLine directionLine, Surface surface){
        double ballxVelocity = ball.getxVelocity();
        double ballyVelocity = ball.getyVelocity();

        double frictionConstant = SurfaceHandler.checkSurface(ball, surface);
        int directionAngle = directionLine.getDegreeAngle();

        double cosinus = Math.cos(Math.toRadians(directionAngle));
        double sinus = Math.sin(Math.toRadians(directionAngle));

        if(ballxVelocity > 0){
            if(cosinus <= 0){
                cosinus *= -1;
            }
            ball.setxVelocity(ball.getxVelocity()-(frictionConstant*cosinus));
            if(ball.getxVelocity() <= 0){
                ball.setxVelocity(0);
            }
        }
        if(ballxVelocity < 0){
            if(cosinus >= 0){
                cosinus *= -1;
            }
            ball.setxVelocity(ball.getxVelocity()-(frictionConstant*cosinus));
            if(ball.getxVelocity() >= 0){
                ball.setxVelocity(0);
            }
        }
        if(ballyVelocity > 0){
            if(sinus <= 0){
                sinus *= -1;
            }
            ball.setyVelocity(ball.getyVelocity()-(frictionConstant*sinus));
            if(ball.getyVelocity() <= 0){
                ball.setyVelocity(0);
            }
        }
        if(ballyVelocity < 0){
            if(sinus >= 0){
                sinus *= -1;
            }
            ball.setyVelocity(ball.getyVelocity()-(frictionConstant*sinus));
            if(ball.getyVelocity() >= 0){
                ball.setyVelocity(0);
            }
        }
    }
}
