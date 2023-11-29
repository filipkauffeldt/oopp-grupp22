package com.crocket;

import java.awt.*;
import java.io.IOException;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class LevelView extends JLayeredPane {
    private final ILevel level;
    private TextureManager textureManager;

    public LevelView(ILevel level, TextureManager textureManager) {
        this.level = level;
        this.textureManager = textureManager;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            drawSurface(g);
        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }


    private void drawSurfaceTile(Graphics g, Surface surface, int x, int y) throws IOException {
        g.drawImage(textureManager.getTexture(surface.name()), x * 100, y * 100, this);
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

    public void drawEntities(Set<DrawableEntity> drawableEntities) throws IOException {
        JLabel entityLabel;
        for( DrawableEntity entity : drawableEntities){
            ImageIcon Image = new ImageIcon(textureManager.getTexture(entity.getTypeName()));
            entityLabel = new JLabel(Image); 
            entityLabel.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
            this.add(entityLabel, 0);
            }
        }
    
    
    
    
}
