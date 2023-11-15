package com.crocket;

public enum Field {
    ICE("crocket/assets/textures/Nice.png"),
    SAND("crocket/assets/textures/Anakin.png"),
    GRASS("crocket/assets/textures/Weed.png");


    private final String texturePath;
    
    private Field(String texturePath){
        this.texturePath = texturePath;
    }
}
