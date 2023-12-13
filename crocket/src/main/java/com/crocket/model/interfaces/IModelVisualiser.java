package com.crocket.model.interfaces;

import java.util.Set;

import com.crocket.model.DrawableEntity;

/**
 * The interface for a model visualizer, responsible for updating and notifying subscribers about changes in the model.
 */
public interface IModelVisualiser {
    /**
     * Updates the subscriber with a new set of drawable entities.
     * 
     * @param drawableEntities the set of drawable entities to be updated
     */
    public void update(Set<DrawableEntity> drawableEntities);

    /**
     * Notifies the visualizer that a player has won the game.
     *
     * @param name the name of the winning player
     */
    public void notifyPlayerWon(String name);
}
