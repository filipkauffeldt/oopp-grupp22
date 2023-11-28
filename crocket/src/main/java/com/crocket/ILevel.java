package com.crocket;

import java.util.Set;

public interface ILevel {
    public int getLevelHeight();

    public int getLevelWidth();

    public Surface[][] getLevelTilemap();

    public Set<Entity> getEntities();

    public Set<IMovable> getMovables();

    public Set<ICollidable> getCollidables();

}
