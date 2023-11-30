package com.crocket;

import static com.crocket.Surface.*;

import java.util.HashSet;
import java.util.Set;

public class Level1 implements ILevel {
    private int width = 25;
    private int height = 15;
    private Set<Entity> entities = new HashSet<Entity>();
    private Set<IMovable> movables = new HashSet<IMovable>();
    private Set<ICollidable> collidables = new HashSet<ICollidable>();
    private Surface[][] tilemap = {
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

    public Surface[][] getLevelSurfacemap() {
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

    public Level1() {
        entities.add(new Hoop(30, 30, 22, 100, 100, Direction.NORTH));
    }
}
