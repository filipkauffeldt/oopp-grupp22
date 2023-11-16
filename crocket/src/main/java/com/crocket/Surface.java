package com.crocket;

public enum Surface {
    ICE("crocket/assets/textures/Nice.png"),
    SAND("crocket/assets/textures/Anakin.png"),
    GRASS("crocket/assets/textures/Weed.png");

    private final String texturePath;

    private Surface(String texturePath) {
        this.texturePath = texturePath;
    }

    public String getFieldTexturePath() {
        return texturePath;
    }

}
