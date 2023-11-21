package com.crocket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CroquetController implements KeyListener{
    
    private CroquetView view;
    
    private Ball ball;

    public CroquetController(CroquetView view, Ball ball){
        this.view = view;
        this.ball = ball;
        view.addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent ke){
        if (ke.getKeyCode() == KeyEvent.VK_SPACE){
            ball.startBall(4, 4, 2);
            
        }
    }

    public void keyReleased(KeyEvent ke){
        
    }

    public void keyTyped(KeyEvent ke){

    }

    public void update(){
        ball.move();
        view.moveBall((int)ball.getxPosition(),(int)ball.getyPosition());
    }
}
