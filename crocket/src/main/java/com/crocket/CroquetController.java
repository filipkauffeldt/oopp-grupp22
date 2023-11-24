package com.crocket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CroquetController implements KeyListener{
    
    private CroquetView view;
    
    private Ball ball;
    private Stone stone;

    private DirectionLine directionLine;

    public CroquetController(CroquetView view, Ball ball, Stone stone, DirectionLine directionLine){
        this.view = view;
        this.ball = ball;
        this.stone = stone;
        this.directionLine = directionLine;

        view.addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent ke){
        switch(ke.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                directionLine.decrementDegreeAngle();
                break;
            case KeyEvent.VK_D:
                directionLine.decrementDegreeAngle();
                break;
            case KeyEvent.VK_LEFT:
                directionLine.incrementDegreeAngle();
                break;
            case KeyEvent.VK_A:
                directionLine.incrementDegreeAngle();
                break;
            case KeyEvent.VK_SPACE:
                int degreeAngle = directionLine.getDegreeAngle();
                double sinus = Math.sin(degreeAngle);
                double cosinus = Math.cos(degreeAngle);
                ball.startBall(cosinus, sinus, 2);
                break;
        }
    }

    public void keyReleased(KeyEvent ke){
        
    }

    public void keyTyped(KeyEvent ke){

    }

    public void update(){
        ball.move();
        if(CollisionHandler.intersect(stone, ball)){
            System.out.print("wow");
            stone.collideWithBall(ball);
        }
        

        view.entity.setLocation((int)ball.getxPosition(),(int)ball.getyPosition());
        view.stone.setLocation((int)stone.getxPosition(), (int)stone.getyPosition());
    }
}

