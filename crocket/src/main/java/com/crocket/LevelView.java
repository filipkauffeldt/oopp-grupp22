package com.crocket;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelView extends JPanel {
    private final ILevel level;
    TextureManager textureManager;

    public LevelView(ILevel level) {
        this.level = level;
        this.textureManager = new TextureManager();
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            drawSurface(g);
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }


    private void drawSurfaceTile(Graphics g, Surface surface, int x, int y) throws IOException {
        textureManager.updateSurfaceTextures(surface);
        g.drawImage(textureManager.getSurfaceTexture(surface), x * 100, y * 100, this);
    }

    private void drawSurface(Graphics g) throws IOException{
        Surface[][] levelTilemap = this.level.getLevelTilemap();
        for (int y = 0; y < this.level.getLevelHeight(); y++) {
            for (int x = 0; x < this.level.getLevelWidth(); x++) {
                Surface surface = levelTilemap[y][x];
                drawSurfaceTile(g, surface, x, y);
            }
        }
    }

    public void drawEntities(Set<DrawableEntity> drawableEntities) {
        for( DrawableEntity entity : drawableEntities){
                
            }
        }
    
    
}
