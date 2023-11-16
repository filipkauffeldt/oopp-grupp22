package com.crocket;

import java.util.PriorityQueue;
import java.util.List;


public class Player implements IEventListener{
    int strokes;
    boolean finished;
    PriorityQueue<Entity> unpassedHoops; //Queue of hoops that have not been passed through yet
    
    Player(List<Entity>  hoops) {
        this.unpassedHoops =  new PriorityQueue<Entity>(hoops); 
        this.strokes = 0;
        this.finished = false;

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
    public void update(Hoop hoop) {
        if (this.unpassedHoops.peek() == hoop) {
            this.unpassedHoops.poll();
        }
    }
    
    public void incrementStrokes() {
        this.strokes++;
    }

    public int getStrokes() {
        return this.strokes;
    }
    
}
