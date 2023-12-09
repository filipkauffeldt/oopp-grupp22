package com.crocket.model;

import java.util.Queue;

import com.crocket.model.entity.Ball;
import com.crocket.model.entity.Entity;
import com.crocket.model.interfaces.IEventListener;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import com.crocket.model.interfaces.IPowerUp;


public class Player implements IEventListener{
    private String name;
    private int strokes;
    private int score;
    private boolean finished;
    private Queue<Entity> remainingTargets; //Queue of hoops and peg that have not been passed yet
    private Ball ball;
    private List<IPowerUp> powerUps;
    
    public Player(Ball ball, String name) {
        this.remainingTargets =  new LinkedList<Entity>(); 
        this.strokes = 0;
        this.finished = false;
        this.ball = ball;
        this.name = name;   
        this.powerUps = new ArrayList<IPowerUp>();

    }

    //Checks if the player has passed through all hoops
    public boolean hasWon() {
        if (this.remainingTargets.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //Gets a hoop a ball has passed under and check if it is the next hoop in the queue
    //If it is, it removes it from the queue if not the hoops has been passed in the wrong order
    @Override
    public void handleEvent(PassTargetEvent event) {
        if (event.getBall() != ball) return;
        
        Entity target = event.getTarget();
        if (this.remainingTargets.peek() == target) {
            this.remainingTargets.poll();
            this.incrementScore();
            System.out.println("Score!");
        }
    }
    
    @Override 
    public void handleEvent(HitPowerUpEvent event) {
        if (event.getBall() != ball) return;
        this.powerUps.add(event.getPowerUp());
    }

    public void applyPowerUp(Integer index) {
        IPowerUp powerUp = this.powerUps.get(index);
        powerUp.applyPowerUp(this.ball);
        this.powerUps.remove(powerUp);
    } 

    private void incrementScore() {
        this.score++;
    }

    public void incrementStrokes() {
        this.strokes++;
    }

    public void resestStrokes() {
        this.strokes = 0;
    }

    public void addTarget(Entity target) {
        this.remainingTargets.add(target);
    }

    public void setTargets(Queue<Entity> targets) {
        this.remainingTargets.clear();
        for (Entity target : targets) {
            this.addTarget(target);
        }
        
    }

    public void addPowerUp(IPowerUp powerUp) {
        this.powerUps.add(powerUp);
    }

    public void addPowerUps(List<IPowerUp> powerUps) {
        for (IPowerUp powerUp : powerUps) {
            this.addPowerUp(powerUp);
        }
    }

    public void shootBall(double angle, double power) {
        double sinus = Math.sin(Math.toRadians(angle));
        double cosinus = Math.cos(Math.toRadians(angle));
        
        this.ball.startBall(sinus, cosinus, power);

        incrementStrokes();
    }

    public Queue<Entity> getRemainingTargets() {
        return remainingTargets;
    }
    
    public int getStrokes() {
        return this.strokes;
    }
    
    public Ball getBall() {
        return ball;

    }
    
}

