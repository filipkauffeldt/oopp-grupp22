package com.crocket;

import java.util.Queue;
import java.util.LinkedList;


public class Player implements IEventListener{
    private int strokes;
    private boolean finished;
    private Queue<Entity> remainingTargets; //Queue of hoops and peg that have not been passed yet
    private Ball ball;
    
    Player(Ball ball) {
        this.remainingTargets =  new LinkedList<Entity>(); 
        this.strokes = 0;
        this.finished = false;
        this.ball = ball;

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
        }
    }
    
    public void incrementStrokes() {
        this.strokes++;
    }

    //Setters and getters
    public void resestStrokes() {
        this.strokes = 0;
    }

    public void addTarget(Entity target) {
        this.remainingTargets.add(target);
    }

    public void setTargets(Queue<Entity> targets) {
        this.remainingTargets.clear();
        for (Entity target : targets) {
            this.remainingTargets.add(target);
        }
        
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

