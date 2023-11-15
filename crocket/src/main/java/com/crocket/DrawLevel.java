package com.crocket;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class DrawLevel extends JPanel {
    private Level level;

    public DrawLevel(Level level){
        this.level = level;
    }
    
    @Override
    public void paintComponent(Graphics g){
        try{
            level.validateLevel();
            drawLevel(g);
        }
        catch(IllegalArgumentException  |  NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void getTileTexture(Graphics g, Field[][] levelTilemap, int y, int x) {
        String tileTexturePath = levelTilemap[y][x].getFieldTexturePath();
        if(tileTexturePath == null){
            throw new NullPointerException("Tile texture not found!");
        }
        Image tileTexture = Toolkit.getDefaultToolkit().getImage(tileTexturePath);
        g.drawImage(tileTexture, x*100, y*100, this);
    }

    private void drawLevel(Graphics g) {
        Field[][] levelTilemap = this.level.getLevelTilemap();
        for(int y = 0; y < this.level.getLevelHeight(); y++){
            for(int x = 0; x < this.level.getLevelWidth(); x++){
                getTileTexture(g, levelTilemap, y, x);
            }
        }
    }

}


   