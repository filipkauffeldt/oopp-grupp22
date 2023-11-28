package com.crocket;

public enum Surface {
    ICE("crocket/assets/textures/IceTile.png"),
    SAND("crocket/assets/textures/SandTile.png"),
    GRASS("crocket/assets/textures/GrassTile.png");

    private final String texturePath;

    private Surface(String texturePath) {
        this.texturePath = texturePath;
    }

    public String getFieldTexturePath() {
        return texturePath;
    }

}
