package com.crocket;

public interface Level {
    public int getLevelHeight();
    public int getLevelWidth();
    public Field[][] getLevelTilemap();
    public void validateLevel();
}
