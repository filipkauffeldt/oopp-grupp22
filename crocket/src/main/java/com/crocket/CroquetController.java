package com.crocket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CroquetController implements KeyListener{
    
    private CroquetView view;
    private Ball ball;
    private DirectionLine directionLine;
    double friction = 0.1;
    double power;
    double sinus;
    double cosinus;

    public CroquetController(CroquetView view, Ball ball, DirectionLine directionLine){
        this.view = view;
        this.ball = ball;
        this.directionLine = directionLine;

        view.addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent ke){
        switch(ke.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                directionLine.incrementDegreeAngle();
                break;
            case KeyEvent.VK_D:
                directionLine.incrementDegreeAngle();
                break;
            case KeyEvent.VK_LEFT:
                directionLine.decrementDegreeAngle();
                break;
            case KeyEvent.VK_A:
                directionLine.decrementDegreeAngle();
                break;
            case KeyEvent.VK_SPACE:
                double degreeAngle = directionLine.getDegreeAngle();
                degreeAngle = degreeAngle * (Math.PI/180);
                sinus = Math.sin(degreeAngle);
                cosinus = Math.cos(degreeAngle);
                
                power+=1;
                if(power == 10){
                    power = 10;
                }
                break;
        }
    }

    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            ball.startBall(cosinus, sinus, power);
            power = 1;
        }
    }

    public void keyTyped(KeyEvent ke){

    }

    public void update(){
        ball.move();
        view.moveBall((int)ball.getxPosition(),(int)ball.getyPosition());
    
        if(ball.getxVelocity() > 0){
            ball.setxVelocity(ball.getxVelocity()-(friction*cosinus));
            if(ball.getxVelocity() <= 0){
                ball.setxVelocity(0);
            }
        }
        
        else if(ball.getxVelocity() < 0){
            ball.setxVelocity(ball.getxVelocity()-(friction*cosinus));
            if(ball.getxVelocity() >= 0){
                ball.setxVelocity(0);
            }
        }
        
        if(ball.getyVelocity() > 0){
            ball.setyVelocity(ball.getyVelocity()-(friction*sinus));
            if(ball.getyVelocity() <= 0){
                ball.setyVelocity(0);
            }
        }
        
        else if(ball.getyVelocity() < 0){
            ball.setyVelocity(ball.getyVelocity()-(friction*sinus));
            if(ball.getyVelocity() >= 0){
                ball.setyVelocity(0);
            }
        }
    }
}
