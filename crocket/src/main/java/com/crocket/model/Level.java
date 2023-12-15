package com.crocket.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.Stone;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.IMovable;
import com.crocket.shared.SurfaceType;

/**
 * Represents a level in the croquet game. Has a list of all entities in the level, a list of all movable entities in the level, a list of all collidable entities in the level, a list of all target entities in the level with the last target to be hit last in the list, a width, a height and a tilemap.
 */
public abstract class Level {
    private int width = 25;
    private int height = 15;

    private Set<Entity> entities = new HashSet<Entity>();
    private Set<IMovable> movables = new HashSet<IMovable>();
    private Set<ICollidable> collidables = new HashSet<ICollidable>();
    private List<Entity> targets = new ArrayList<Entity>();
    private SurfaceType[][] tilemap;

    /**
     * Creates a new level with the given width, height and tilemap.
     * 
     * @param width
     * @param height
     * @param tilemap
     */
    protected Level(int width, int height, SurfaceType[][] tilemap) {
        this.width = width;
        this.height = height;
        this.tilemap = tilemap;
    }
    
    /**
     * Creates a new level with the same width, height and tilemap as the given level.
     * @param levelCopy
     */
    protected Level(Level levelCopy){
        this.width = levelCopy.width;
        this.height = levelCopy.height;
        this.tilemap = levelCopy.tilemap;
        this.entities = levelCopy.entities;
        this.movables = levelCopy.movables;
        this.collidables = levelCopy.collidables;
    }

    /**
     * Adds a stone to the level.
     * @param stone
     */
    protected void addStone(Stone stone) {
        entities.add(stone);
        collidables.add(stone);
    }

    /**
     * Adds a hoop to the level.
     * @param hoop
     */
    protected void addHoop(Hoop hoop) {
        entities.add(hoop);
        collidables.add(hoop);
        targets.add(hoop);
    }
    
    protected void addPeg(Peg peg) {
        entities.add(peg);
        collidables.add(peg);
        targets.add(peg);
    }

    /**
     * Returns the height of the level.
     * 
     * @return int representing the height of the level
     */
    public int getLevelHeight() {
        return height;
    }

    /**
     * Returns the width of the level.
     * 
     * @return int representing the width of the level
     */
    public int getLevelWidth() {
        return width;
    }

    /**
     * Returns the surface map of the level.
     * 
     * @return 2D array of Surface objects representing the surface map of the level
     */
    public SurfaceType[][] getLevelSurfacemap() {
        return tilemap;
    }

    /**
     * Returns a set of all entities in the level.
     * 
     * @return Set of Entity objects representing all entities in the level
     */
    public Set<Entity> getEntities() {
        return entities;
    }

    /**
     * Returns a set of all movable entities in the level.
     * 
     * @return Set of IMovable objects representing all movable entities in the level
     */
    public Set<IMovable> getMovables() {
        return movables;
    }

    /**
     * Returns a set of all collidable entities in the level.
     * 
     * @return Set of ICollidable objects representing all collidable entities in the level
     */
    public Set<ICollidable> getCollidables() {
        return collidables;
    }

    /**
     * Returns a new List of all target entities in the level.
     * 
     * @return Set of Entity objects representing all target entities in the level
     */
    public List<Entity> getTargets() {
        return new ArrayList<Entity>(targets);
    }
}