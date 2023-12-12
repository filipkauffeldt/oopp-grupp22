package com.crocket.model.interfaces;

import com.crocket.model.PassTargetEvent;
import com.crocket.model.HitPowerUpEvent;

import com.crocket.model.PassTargetEvent;
import com.crocket.model.HitPowerUpEvent;

/**
 * The IEventListener interface represents a listener for target events (like hitting a hop or a peg) in the game.
 * It provides a method to handle such events.
 * 
 * This interface is expected to be implemented by classes that need to respond to target events.
 */
public interface IEventListener {
    public void handleEvent(PassTargetEvent event);
    
    public void handleEvent(HitPowerUpEvent event);
}
