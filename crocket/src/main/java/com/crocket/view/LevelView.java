package com.crocket.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.crocket.model.DrawableEntity;
import com.crocket.model.interfaces.IModelVisualiser;
import com.crocket.shared.SurfaceType;
import com.crocket.view.interfaces.ILevelView;

public class LevelView extends JLayeredPane implements ILevelView {
    private SurfaceType[][] levelSurfacemap;
    private TextureManager textureManager;
    private int levelHeight;
    private int levelWidth;
    private PowerPanel powerPanel;

    public LevelView() {
        setDoubleBuffered(true);
        this.textureManager = new TextureManager();
        this.textureManager.loadTextures();
        powerPanel = new PowerPanel();
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

    private void drawSurfaceTile(Graphics g, SurfaceType surface, int x, int y) throws IOException {
        BufferedImage surfaceImage = textureManager.getTexture(surface.name());
        g.drawImage(surfaceImage, x * surfaceImage.getWidth(), y * surfaceImage.getHeight(), this);
    }

    public void drawSurfaces(Graphics g) throws IOException {
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                SurfaceType surface = levelSurfacemap[y][x];
                drawSurfaceTile(g, surface, x, y);
            }
        }
    }

    private void drawLowerLayerEntity(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = makeLabel(entity, bufferedImage);
        label.setBackground(Color.RED);
        add(label, JLayeredPane.DEFAULT_LAYER);
    }

    private void drawMiddleLayerEntity(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = makeLabel(entity, bufferedImage);
        add(label, JLayeredPane.MODAL_LAYER);
    }

    private void drawLowerLayeredEntity(DrawableEntity entity) {
        BufferedImage bufferedImage = textureManager.getTexture(entity.getTypeName());
        drawLowerLayerEntity(entity, bufferedImage);
    }

    private JLabel makeLabel(DrawableEntity entity, BufferedImage bufferedImage) {
        JLabel label = new JLabel(new ImageIcon(bufferedImage));
        label.setBounds(entity.getxPosition(), entity.getyPosition(), entity.getWidth(), entity.getHeight());
        return label;
    }

    private void drawDirectionLine(DrawableEntity entity) {
        DrawDirectionLine panel = new DrawDirectionLine();
        panel.setBounds(entity.getxPosition(), entity.getyPosition(), DrawDirectionLine.WIDTH,
                DrawDirectionLine.HEIGHT);

        panel.changeAngle(entity.getCosinus(), entity.getSinus());
        add(panel, JLayeredPane.MODAL_LAYER);
        panel.repaint();
    }

    private void drawPowerMeter() {
        powerPanel.setBounds(powerPanel.getXPOS(), powerPanel.getYPOS(), powerPanel.getWidth(), powerPanel.getHeight());
        add(powerPanel, MODAL_LAYER);
    }

    public void incrementPowerIndicator() {
        powerPanel.incrementIndicator();
        powerPanel.repaint();
    }

    public void decrementPowerIndicator() {
        powerPanel.decrementIndicator();
        powerPanel.repaint();
    }

    public void resetPowerIndicator() {
        powerPanel.resetIndicator();
        powerPanel.repaint();
    }

    private void getHoopTexture(DrawableEntity entity) {
        int rotation = entity.getRotation();
        String topHoopTexture;
        String lowerHoopTexture;

        switch (rotation) {
            case 0:
                topHoopTexture = "HOOPTOPHORIZONTAL";
                lowerHoopTexture = "HOOPLOWERSOUTH";
                break;
            case 90:
                topHoopTexture = "HOOPTOPVERTICAL";
                lowerHoopTexture = "HOOPLOWEREAST";
                break;
            case 180:
                topHoopTexture = "HOOPTOPHORIZONTAL";
                lowerHoopTexture = "HOOPLOWERNORTH";
                break;
            case 270:
                topHoopTexture = "HOOPTOPVERTICAL";
                lowerHoopTexture = "HOOPLOWERWEST";
                break;
            default:
                throw new IllegalArgumentException("Invalid rotation");
        }

        if (entity.isActive()) {
            topHoopTexture += "HIGHLIGHTED";
            lowerHoopTexture += "HIGHLIGHTED";
        }

        BufferedImage bufferedImage = textureManager.getTexture(lowerHoopTexture);
        drawLowerLayerEntity(entity, bufferedImage);

        bufferedImage = textureManager.getTexture(topHoopTexture);
        drawMiddleLayerEntity(entity, bufferedImage);
    }

    public void drawEntities(Set<DrawableEntity> entities) {
        removeAll();
        for (DrawableEntity entity : entities) {
            drawEntity(entity);
        }
        repaint();
    }

    private void drawEntity(DrawableEntity entity) {
        switch (entity.getType()) {
            case HOOP:
                getHoopTexture(entity);
                return;
            case PEG:
                drawMiddleLayerEntity(entity, textureManager.getTexture(entity.getTypeName()));
                return;
            case BALL:
                drawLowerLayeredEntity(entity);
                return;
            case STONE:
                drawLowerLayeredEntity(entity);
                return;
            case DIRECTIONLINE:
                drawDirectionLine(entity);
                drawPowerMeter();
                return;
            default:
                throw new IllegalArgumentException("Unknown entity class: " + entity.getTypeName());
        }
    }

    public void displayWinner(String playerName) {
        JOptionPane.showMessageDialog(null, playerName + " won!", "Game over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setSurfaceMap(SurfaceType[][] levelSurfacemap, int levelHeight, int levelWidth) {
        this.levelSurfacemap = levelSurfacemap;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
    }
}
