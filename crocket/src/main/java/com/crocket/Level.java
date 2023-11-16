package com.crocket;

public interface Level {
    public int getLevelHeight();

    public int getLevelWidth();

    public Surface[][] getLevelTilemap();

    public void validateLevel();
}
