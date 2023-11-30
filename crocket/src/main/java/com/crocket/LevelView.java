package com.crocket;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelView extends JPanel implements ILevelView {
    private Surface[][] levelSurfacemap;
    private Map<String, BufferedImage> textureCacheMap = new HashMap<>();
    private int levelHeight;
    private int levelWidth;



    @Override
    protected void paintComponent(Graphics g) {
        try {
            drawSurfaces(g);
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void drawSurfaces(Graphics g) throws IOException {
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                getTileTexture(g, y, x);
            }
        }
    }
    
    private void getTileTexture(Graphics g, int y, int x) throws IOException {
        BufferedImage tileTexture;
        String tileTexturePath = levelSurfacemap[y][x].getFieldTexturePath();
        updateTextureCache(tileTexturePath);
        tileTexture = textureCacheMap.get(tileTexturePath);
        g.drawImage(tileTexture, x * 100, y * 100, this);
    }


    private void updateTextureCache(String tileTexturePath) throws IOException {
        if (!textureCacheMap.containsKey(tileTexturePath)) {
            BufferedImage tileTexture = ImageIO.read(new File(tileTexturePath));
            textureCacheMap.put(tileTexturePath, tileTexture);
        }
    }

    public void drawEntities(Set<DrawableEntity> entities) {
        // Implement the logic to draw entities here
        // Should be called from the controller when the entities are updated
    }


    public void setSurfaceMap(Surface[][] levelSurfacemap, int levelHeight, int levelWidth) {
        this.levelSurfacemap = levelSurfacemap;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth; 
    }

}

