package com.crocket;

import java.util.Queue;
import java.util.LinkedList;


public class Player implements IEventListener{
    int strokes;
    boolean finished;
    Queue<Entity> unpassedHoops; //Queue of hoops that have not been passed through yet
    Ball ball;
    
    Player(Ball ball) {
        this.unpassedHoops =  new LinkedList<Entity>(); 
        this.strokes = 0;
        this.finished = false;
        this.ball = ball;

    }

    //Checks if the player has passed through all hoops
    public boolean hasWon() {
        if (this.unpassedHoops.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //Gets a hoop a ball has passed under and check if it is the next hoop in the queue
    //If it is, it removes it from the queue if not the hoops has been passed in the wrong order
    @Override
    public void handleEvent(PassHoopEvent event) {
        if (event.getBall() != ball) return;
        
        Hoop hoop = event.getHoop();
        if (this.unpassedHoops.peek() == hoop) {
            this.unpassedHoops.poll();
        }
    }
    
    public void incrementStrokes() {
        this.strokes++;
    }

    //Setters and getters
    public void resestStrokes() {
        this.strokes = 0;
    }

    public void addHoop(Hoop hoop) {
        this.unpassedHoops.add(hoop);
    }

    public void setHoops(Queue<Entity> hoops) {
        this.unpassedHoops.clear();
        for (Entity hoop : hoops) {
            this.unpassedHoops.add(hoop);
        }
        
    }
    
    public int getStrokes() {
        return this.strokes;
    }
    
    public Ball getBall() {
        return ball;
    }
}
