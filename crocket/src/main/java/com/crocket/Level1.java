package com.crocket;


public class Level1 implements Level{
    private int width = 5;
    private int height = 5;
    Field[][] tilemap ={{Field.GRASS,Field.GRASS,Field.ICE,Field.GRASS,Field.GRASS},
                        {Field.GRASS,Field.GRASS,Field.GRASS,Field.ICE,Field.GRASS},
                        {Field.GRASS,Field.GRASS,Field.GRASS,Field.GRASS,Field.ICE},
                        {Field.ICE,Field.GRASS,Field.GRASS,Field.GRASS,Field.GRASS},
                        {Field.GRASS,Field.ICE,Field.GRASS,Field.GRASS,Field.GRASS}};
    

    public int getLevelHeight(){
        return height;
    }
    public int getLevelWidth(){
        return width;
    }
    public Field[][] getLevelTilemap(){
        return tilemap;
    }
    public void validateLevel() {
        if (height != tilemap.length) {
            throw new IllegalArgumentException("Level height does not match tilemap height!");
        }
    }
}
