package com.crocket;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class TextureManager {
    private Map<Surface, BufferedImage> surfaceTextureMap;
    private Map<EntityType, BufferedImage> entityTextureMap;

    protected TextureManager() {
        surfaceTextureMap = new HashMap<>();
        entityTextureMap = new HashMap<>();
    }

    private void addSurfaceTexture(Surface surface, BufferedImage textureFile) {
        surfaceTextureMap.put(surface, textureFile);
    }

    private void addEntityTexture(EntityType entityType, BufferedImage textureFile) {
        entityTextureMap.put(entityType, textureFile);
    }

    private void updateSurfaceTextureMap(Surface surface, String texturePath) throws IOException {
        if (!surfaceTextureMap.containsKey(surface)) {
            BufferedImage surfaceTexture = ImageIO.read(new File(texturePath));
            addSurfaceTexture(surface, surfaceTexture);
        }
    }

    private void updateEntityTextureMap(EntityType entityType, String texturePath) throws IOException {
        if (!entityTextureMap.containsKey(entityType)) {
            BufferedImage entityTexture = ImageIO.read(new File(texturePath));
            addEntityTexture(entityType, entityTexture);
        }
    }

    public BufferedImage getSurfaceTexture(Surface surface) {
        return surfaceTextureMap.get(surface);
    }
    
    public BufferedImage getEntityTexture(EntityType entityType) {
        return entityTextureMap.get(entityType);
    }

    public void updateSurfaceTextures(Surface surface) throws IOException {
        switch (surface) {
            case GRASS:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/GrassTile.png");
                break;
            case SAND:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/SandTile.png");
                break;
            case ICE:
                updateSurfaceTextureMap(surface, "crocket/assets/textures/IceTile.png");
                break;
            default:
                throw new IllegalArgumentException("Invalid surface type");
        }
    }

    public void updateEntityTextures(EntityType entityType) throws IOException {
        switch (entityType) {
            case BALL:
                updateEntityTextureMap(entityType, "crocket/assets/textures/Ball.png");
                break;
            case HOOP:
                updateEntityTextureMap(entityType, "crocket/assets/textures/Hoop.png");
                break;
            default:
                throw new IllegalArgumentException("Invalid entity type");
        }
    }
}
