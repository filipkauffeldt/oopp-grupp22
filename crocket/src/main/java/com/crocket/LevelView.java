package com.crocket;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class LevelView extends JLayeredPane implements ILevelView {
    private Surface[][] levelSurfacemap;
    private TextureManager textureManager;
    private int levelHeight;
    private int levelWidth;

    public LevelView(TextureManager textureManager) {
        this.textureManager = textureManager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            drawSurfaces(g);
        } catch (IOException | NullPointerException e ) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void drawSurfaceTile(Graphics g, Surface surface, int x, int y) throws IOException {
        g.drawImage(textureManager.getTexture(surface.name()), x * 100, y * 100, this);
    }

    public void drawSurfaces(Graphics g) throws IOException {
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                Surface surface = levelSurfacemap[y][x];
                drawSurfaceTile(g, surface, x, y);
            }
        }
    }

    private void getNonrotatableTexture(DrawableEntity entity) {
        String typeKey = entity.getTypeName();
        BufferedImage bufferedImage = textureManager.getTexture(typeKey);
        JLabel label = new JLabel(new ImageIcon(bufferedImage));
        label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
        add(new JLabel(new ImageIcon(bufferedImage)), JLayeredPane.DEFAULT_LAYER);
    }

    private void getRotatableTexture(DrawableEntity entity) {
        switch (entity.getRotation()) {
            case 0: // 0 degrees
                BufferedImage bufferedImage = textureManager.getTexture("HOOPLOWER1");
                JLabel label = new JLabel(new ImageIcon(bufferedImage));
                label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
                add(label, JLayeredPane.DEFAULT_LAYER);
                bufferedImage = textureManager.getTexture("HOOPTOP");
                label = new JLabel(new ImageIcon(bufferedImage));
                label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight()); 
                add(label, JLayeredPane.MODAL_LAYER); 
                break;
            case 90: // 90 degrees
            throw new IllegalArgumentException("Unknown entity class");
            case 180: // 180 degrees
                bufferedImage = textureManager.getTexture("HOOPLOWER2");
                label = new JLabel(new ImageIcon(bufferedImage));
                label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
                add(label, JLayeredPane.DEFAULT_LAYER);
                bufferedImage = textureManager.getTexture("HOOPTOP");
                label = new JLabel(new ImageIcon(bufferedImage));
                label.setBounds(entity.getxPosition(), entity.getyPosition() - 100, entity.getWidth(), entity.getHeight()); 
                add(label, JLayeredPane.MODAL_LAYER);
                break; 
            case 270: // 270 degrees
            throw new IllegalArgumentException("Unknown entity class");
            default:
                break;
        }
    }

    public void drawEntities(Set<DrawableEntity> entities) {
        for (DrawableEntity entity : entities) {
            switch (entity.getType()) {
                case HOOP:
                    getRotatableTexture(entity);
                    continue;
                case PEG:
                    getNonrotatableTexture(entity);
                    continue;
                case BALL:
                    getNonrotatableTexture(entity);
                    continue;
                case STONE:
                    getNonrotatableTexture(entity);
                    continue;
                default:
                    continue;
            }
        }
    }

    public void setSurfaceMap(Surface[][] levelSurfacemap, int levelHeight, int levelWidth) {
        this.levelSurfacemap = levelSurfacemap;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
    }
}
