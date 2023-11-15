package com.crocket;


public class Level1 implements Level{
    int width = 5;
    int height = 5;
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
}
