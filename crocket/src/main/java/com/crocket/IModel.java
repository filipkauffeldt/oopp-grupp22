package com.crocket;

import java.util.Set;

/**
 * Facade for the model of the game.
 */
public interface IModel {

    /**
     * Returns a drawable representation of the entities in the current level.
     * @return Set<DrawableEntity> drawableEntities
     */
    public Set<DrawableEntity> getDrawableEntities();

    /**
     * Returns the tilemap representaion of the surfaces in the current level.
     * @return Surface[][] levelTilemap
     */
    public Surface[][] getLevelTilemap();

    /**
     * Sets the current level and populates the entities set with the entities from the level.
     * @param level
     */
    public void setLevel(ILevel level);

    /**
     * Restarts the current level.
     */
    public void restartLevel();

   /**
    * Updates the model. Moves any movable entities and checks for collisions.
    */
    public void update();

    /**
     * Shoots the ball of the active with the given power in the direction specified by the direction set in update aim.
     * @param power
     */
    public void shootBall(int power);

    /**
     * Updates the aim of the active player's ball.
     * @param degrees
     */
    public void updateAim(int degrees);
}
