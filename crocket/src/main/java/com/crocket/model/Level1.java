package com.crocket.model;

import static com.crocket.shared.SurfaceType.*;

import java.util.HashSet;
import java.util.Set;

import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.model.entity.Peg;
import com.crocket.model.entity.Stone;
import com.crocket.model.interfaces.ICollidable;
import com.crocket.model.interfaces.ILevel;
import com.crocket.model.interfaces.IMovable;
import com.crocket.shared.Direction;
import com.crocket.shared.SurfaceType;

public class Level1 implements ILevel {
    private int width = 25;
    private int height = 15;
    
    private Set<Entity> entities = new HashSet<Entity>();
    private Set<IMovable> movables = new HashSet<IMovable>();
    private Set<ICollidable> collidables = new HashSet<ICollidable>();
    private Set<Entity> tragetSet = new HashSet<Entity>();
    private SurfaceType[][] tilemap = {
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS},
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS,GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, ICE, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, ICE, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS },
            { GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, GRASS, SAND, SAND, SAND, SAND, SAND,SAND, SAND, SAND, SAND, SAND, SAND, GRASS, GRASS, GRASS, GRASS} };

    public int getLevelHeight() {
        return height;
    }

    public int getLevelWidth() {
        return width;
    }

    public SurfaceType[][] getLevelSurfacemap() {
        return tilemap;
    }

    public Set<Entity> getEntities() {
        return entities;
    }

    public Set<IMovable> getMovables() {
        return movables;
    }

    public Set<ICollidable> getCollidables() {
        return collidables;
    }

    public Set<Entity> getTargets() {
        return tragetSet;
    }

    public Level1() {
        Stone s = new Stone(30, 30, 300, 500);
        Hoop h = new Hoop(40, 20,32, 4,295, 450, Direction.SOUTH);
        Peg p = new Peg(5, 40, 309, 100);  
        collidables.add(p);
        entities.add(p);
        collidables.add(h);
        entities.add(h);
        tragetSet.add(h);
        collidables.add(s);
        entities.add(s);
    }


    //Defensive copy
    public Level1(Level1 levelCopy){
        this.width = levelCopy.width;
        this.height = levelCopy.height;
        this.tilemap = levelCopy.tilemap.clone();
        this.entities = levelCopy.entities;
        this.movables = levelCopy.movables;
        this.collidables = levelCopy.collidables;
    }
}
