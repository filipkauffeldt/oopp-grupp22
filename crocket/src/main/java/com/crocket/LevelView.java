package com.crocket;

import java.awt.*;
import java.io.IOException;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class LevelView extends JPanel implements ILevelView {
    private Surface[][] levelSurfacemap;
    private Map<String, BufferedImage> textureCacheMap = new HashMap<>();
    private int levelHeight;
    private int levelWidth;



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            drawSurfaces(g);
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }


    private void drawSurfaceTile(Graphics g, Surface surface, int x, int y) throws IOException {
        g.drawImage(textureManager.getTexture(surface.name()), x * 100, y * 100, this);
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

