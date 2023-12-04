package com.crocket.model.interfaces;

import java.util.Set;

import com.crocket.model.entity.Entity;
import com.crocket.shared.SurfaceType;

/**
 * The ILevel interface represents a level in the game.
 * It provides methods to get the height and width of the level, 
 * the surface map of the level, and sets of various types of entities in the level.
 * 
 * This interface is expected to be implemented by classes that define specific levels in the game.
 */
public interface ILevel {

    /**
     * Returns the height of the level.
     * 
     * @return int representing the height of the level
     */
    public int getLevelHeight();

    /**
     * Returns the width of the level.
     * 
     * @return int representing the width of the level
     */
    public int getLevelWidth();

    /**
     * Returns the surface map of the level.
     * 
     * @return 2D array of Surface objects representing the surface map of the level
     */
    public SurfaceType[][] getLevelSurfacemap();

    /**
     * Returns a set of all entities in the level.
     * 
     * @return Set of Entity objects representing all entities in the level
     */
    public Set<Entity> getEntities();

    /**
     * Returns a set of all movable entities in the level.
     * 
     * @return Set of IMovable objects representing all movable entities in the level
     */
    public Set<IMovable> getMovables();

    /**
     * Returns a set of all collidable entities in the level.
     * 
     * @return Set of ICollidable objects representing all collidable entities in the level
     */
    public Set<ICollidable> getCollidables();

    /**
     * Returns a set of all target entities in the level.
     * 
     * @return Set of Entity objects representing all target entities in the level
     */
    public Set<Entity> getTargets();
}