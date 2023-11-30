package com.crocket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CroquetController implements KeyListener{
    
    private CroquetView view;
    private Ball ball;
    private Stone stone;

    private DirectionLine directionLine;

    double degreeAngle;
    double friction = 0.1;
    double power;
    int maxPower = 40;
    double sinus;
    double cosinus;
    Direction dir;
    boolean powerIsMax = false;
    

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
                if(ball.getxVelocity() == 0 || ball.getyVelocity() == 0){
                    directionLine.incrementDegreeAngle();
                }
                break;
            case KeyEvent.VK_D:
                if(ball.getxVelocity() == 0 || ball.getyVelocity() == 0){
                    directionLine.incrementDegreeAngle();
                }
                break;
            case KeyEvent.VK_LEFT:
                if(ball.getxVelocity() == 0 || ball.getyVelocity() == 0){
                    directionLine.decrementDegreeAngle();
                }
                break;
            case KeyEvent.VK_A:
                if(ball.getxVelocity() == 0 || ball.getyVelocity() == 0){
                    directionLine.decrementDegreeAngle();
                }
                break;
            case KeyEvent.VK_SPACE:
                if(ball.getxVelocity() == 0 || ball.getyVelocity() == 0){
                    view.setPowerMeterVisibility(true);
                    if(power >= maxPower){
                        powerIsMax = true;
                    }
                    else if(power <= 1){
                        powerIsMax = false;
                    }
                    
                    if(!powerIsMax){
                        power+=1;
                        view.incrementIndicator();
                    }
                    else{
                        power-=1;
                        view.decrementIndicator();
                    }
                }
                break;
        }
    }

    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_SPACE && ball.getxVelocity() == 0 && ball.getyVelocity() == 0){
            ball.startBall(cosinus, sinus, power);
            power = 1;
            view.line.setVisible(false);   
            view.setPowerMeterVisibility(false);
            view.resetIndicator();
        }
    }

    public void keyTyped(KeyEvent ke){

    }

    public void update(){
        
        ball.move();
        degreeAngle = directionLine.getDegreeAngle();
        degreeAngle = Math.toRadians(degreeAngle);
        sinus = Math.sin(degreeAngle);
        cosinus = Math.cos(degreeAngle);
        
        if(CollisionHandler.intersect(ball, stone)){
            stone.collideWithBall(ball);
            
        }

        view.moveBall((int)ball.getxPosition(), (int)ball.getyPosition());
        view.setStone((int)stone.getxPosition(), (int)stone.getyPosition());
        view.updateLine((int)ball.getxPosition()+ball.getWidth()/2, (int)ball.getyPosition()+ball.getHeight()/2, (int)(cosinus*50), (int)(sinus*50));
        view.updatePowerMeter();
    
        if(ball.getxVelocity() > 0){
            if (cosinus <= 0){
                cosinus *= -1;
            }
            ball.setxVelocity(ball.getxVelocity()-(friction*cosinus));
            if(ball.getxVelocity() <= 0){
                ball.setxVelocity(0);
                view.line.setVisible(true);
            }
        }
        
        else if(ball.getxVelocity() < 0){
            if (cosinus >= 0){
                cosinus *= -1;
            }
            ball.setxVelocity(ball.getxVelocity()-(friction*cosinus));
            if(ball.getxVelocity() >= 0){
                ball.setxVelocity(0);
                view.line.setVisible(true);
            }
        }
        
        if(ball.getyVelocity() > 0){
            if (sinus <= 0){
                sinus *= -1;
            }
            ball.setyVelocity(ball.getyVelocity()-(friction*sinus));
            if(ball.getyVelocity() <= 0){
                ball.setyVelocity(0);
                view.line.setVisible(true);
            }
        }
        
        else if(ball.getyVelocity() < 0){
            if (sinus >= 0){
                sinus *= -1;
            }
            ball.setyVelocity(ball.getyVelocity()-(friction*sinus));
            if(ball.getyVelocity() >= 0){
                ball.setyVelocity(0);
                view.line.setVisible(true);
            }
            
        }
        
    }

    

}

