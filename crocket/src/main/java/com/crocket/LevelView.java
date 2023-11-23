package com.crocket;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelView extends JPanel {
    private final ILevel level;
    private Map<String, BufferedImage> textureCacheMap;

    public LevelView(ILevel level) {
        this.level = level;
        textureCacheMap = new HashMap<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            level.validateLevel();
            drawLevel(g);
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void getTileTexture(Graphics g, Surface[][] levelTilemap, int y, int x) throws IOException {
        BufferedImage tileTexture;
        String tileTexturePath = levelTilemap[y][x].getFieldTexturePath();
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

    private void drawLevel(Graphics g) throws IOException{
        Surface[][] levelTilemap = this.level.getLevelTilemap();
        for (int y = 0; y < this.level.getLevelHeight(); y++) {
            for (int x = 0; x < this.level.getLevelWidth(); x++) {
                getTileTexture(g, levelTilemap, y, x);
            }
        }
    }
    
}
