package com.crocket;

import java.util.List;
import java.util.Set;

/**
 * Facade for the model of the game.
 * Requires an ILevel to be set with setLevel().
 * Requires at least one Player to be added.
 */
public interface IModel {

    /**
     * Returns a drawable representation of the entities in the current level.
     * @return Set<DrawableEntity> drawableEntities
     */
    public Set<DrawableEntity> getDrawableEntities();

    /**
     * Returns the tilemap representation of the surfaces in the current level.
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

    /**
     * Decrements the aim angle of the active player's ball.
     */
    public void aimRight();

    /**
     * Increments the aim angle of the active player's ball.
     */
    public void aimLeft();

    /**
     * Overwrites the model's List of Player with a new List of Player .
     * @param players
     */
    public void setPlayers(List<Player> players);

    /**
     * Adds a Player to the model's List of Player.
     * @param player
     */
    public void addPlayer(Player player);

    /**
     * Removes all players from the model.
     */
    public void clearPlayers();
}
