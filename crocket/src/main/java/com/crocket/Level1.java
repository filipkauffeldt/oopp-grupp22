package com.crocket;


public class Level1 {
    int widht = 5;
    int height = 5;
    Field[][] tilemap ={{Field.GRASS,Field.GRASS,Field.ICE,Field.GRASS,Field.GRASS},
                        {Field.GRASS,Field.GRASS,Field.GRASS,Field.ICE,Field.GRASS},
                        {Field.GRASS,Field.GRASS,Field.GRASS,Field.GRASS,Field.ICE},
                        {Field.ICE,Field.GRASS,Field.GRASS,Field.GRASS,Field.GRASS},
                        {Field.GRASS,Field.ICE,Field.GRASS,Field.GRASS,Field.GRASS}};
                        
    public int getLevelHeight(){
        return height;
    }
    public int getLevelWidht(){
        return widht;
    }
    public Field[][] getLevelTilemap(){
        return tilemap;
    }
}
