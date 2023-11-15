package com.crocket;
import java.awt.*;



public class Draw extends Canvas {
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");
    Image grassImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Weed.png");
    Image sandImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Anakin.png");
    Image iceImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Nice.png");

    //temp positioning
    public void paint(Graphics g){
        
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
    }

    public void paint(Graphics g, Level1){
        Field[][] levelTilemap = Level1.getLevelTilemap();
        for(int y = 0; y < Level1.getLevelHeight(); y++){
            for(int x = 0; x < Level1.getgetLevelWidht(); x++){
                levelTilemap[y][x] 
            }
        }
    }

    
}
