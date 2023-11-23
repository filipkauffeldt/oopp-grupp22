package com.crocket;

public interface ILevel {
    public int getLevelHeight();

    public int getLevelWidth();

    public Surface[][] getLevelTilemap();

    public void validateLevel();

}
