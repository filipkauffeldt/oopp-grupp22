package com.crocket.model.interfaces;

import java.util.Set;

import com.crocket.model.entity.Entity;
import com.crocket.model.entity.Hoop;
import com.crocket.shared.Surface;

public interface ILevel {
    public int getLevelHeight();

    public int getLevelWidth();

    public Surface[][] getLevelSurfacemap();

    public Set<Entity> getEntities();

    public Set<IMovable> getMovables();

    public Set<ICollidable> getCollidables();

    public Set<Entity> getTargets();


}
