package com.crocket;
import java.awt.*;
import java.lang.Exception;


public class Draw extends Canvas {
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");
    Image grassImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Weed.png");
    Image sandImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Anakin.png");
    Image iceImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Nice.png");


    //temp positioning
    /*public void paint(Graphics g){
        
        for(int x = 0; x < screen.width/2; x+=100){
            for(int y = 0; y < screen.height/2; y+=100){        
                g.drawImage(iceImg, x, y, this);
            }
            for(int y = screen.height/2; y < screen.height; y+=100){
                g.drawImage(grassImg, x, y, this);
            }
        }

        for(int x = screen.width/2; x < screen.width; x+=100){
            for(int y = 0; y < screen.height/2; y+=100){        
                g.drawImage(iceImg, x, y, this);
            }
            for(int y = screen.height/2; y < screen.height; y+=100){
                g.drawImage(sandImg, x, y, this);
            }
        }
        
        g.drawImage(ballImg, 1000, 600, this);
    }*/
    
public void paint(Graphics g, Level1 level1){
    Field[][] levelTilemap = level1.getLevelTilemap();
    for(int y = 0; y < level1.getLevelHeight(); y++){
        for(int x = 0; x < level1.getLevelWidth(); x++){
            String tileTexturePath = levelTilemap[y][x].getFieldTexturePath();
            if(tileTexturePath == null){
                throw new NullPointerException("Tile texture not found!");
            }
            Image tileTexture = Toolkit.getDefaultToolkit().getImage(tileTexturePath);
            g.drawImage(tileTexture, x * 100, y * 100, 100, 100, null);
        }
    } 
}

    
}
