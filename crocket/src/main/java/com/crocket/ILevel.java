package com.crocket;

public interface ILevel {
    public int getLevelHeight();

    public int getLevelWidth();

    public Surface[][] getLevelTilemap();

    public Set<Entity> getEntities();

    public Set<IMovable> getMovables();

    public Set<ICollidable> getCollidables();

    public Set<Peg> getPegs();

    public Set<Hoop> getHoops();

    public void validateLevel();

}
