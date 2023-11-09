package com.crocket;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class Player {
    int strokes;
    boolean finished;
    PriorityQueue unpassedHoops; //TODO add parameter to type
    
    Player(ArrayList hoops) {
        this.unpassedHoops =  new PriorityQueue(hoops); 
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

    

    public int getStrokes() {
        return this.strokes;
    }
    
}
