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
        } catch (IOException | NullPointerException e) {
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

    private void drawLowerLayerEntity(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = makeLabel(entity, bufferedImage);
        add(label, JLayeredPane.DEFAULT_LAYER);
    }

    private void drawMiddleLayerEntity(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = makeLabel(entity, bufferedImage);
        add(label, JLayeredPane.MODAL_LAYER);
    }

    private void drawNoneLayeredEntity(DrawableEntity entity) {
        BufferedImage bufferedImage = textureManager.getTexture(entity.getTypeName());
        drawLowerLayerEntity(entity, bufferedImage);
    }

    private JLabel makeLabel(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = new JLabel(new ImageIcon(bufferedImage));
        label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
        return label;
    }

    private void getHoopTexture(DrawableEntity entity) {
        int rotation = entity.getRotation();
        String topHoopTexture;
        String lowerHoopTexture;

        switch (rotation) {
            case 0:
                topHoopTexture = "HOOPTOPHORIZONTAL";
                lowerHoopTexture = "HOOPLOWERNORTH";
                break;
            case 90:
                topHoopTexture = "HOOPTOPVERTICAL";
                lowerHoopTexture = "HOOPLOWERWEST";
                break;
            case 180:
                topHoopTexture = "HOOPTOPHORIZONTAL";
                lowerHoopTexture = "HOOPLOWERSOUTH";
                break;
            case 270:
                topHoopTexture = "HOOPTOPVERTICAL";
                lowerHoopTexture = "HOOPLOWEREAST";
                break;
            default:
                throw new IllegalArgumentException("Invalid rotation");
        }
        BufferedImage bufferedImage = textureManager.getTexture(lowerHoopTexture);
        drawLowerLayerEntity(entity, bufferedImage);

        bufferedImage = textureManager.getTexture(topHoopTexture);
        drawMiddleLayerEntity(entity, bufferedImage);
    }

    public void drawEntities(Set<DrawableEntity> entities) {
        for (DrawableEntity entity : entities) {
            switch (entity.getType()) {
                case HOOP:
                    getHoopTexture(entity);
                    continue;
                case PEG:
                    drawNoneLayeredEntity(entity);
                    continue;
                case BALL:
                    drawNoneLayeredEntity(entity);
                    continue;
                case STONE:
                    drawNoneLayeredEntity(entity);
                    continue;
                default:
                    throw new IllegalArgumentException("Unknown entity class");
            }
        }
    }

    public void setSurfaceMap(Surface[][] levelSurfacemap, int levelHeight, int levelWidth) {
        this.levelSurfacemap = levelSurfacemap;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
    }
}
