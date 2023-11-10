package com.crocket;
import java.awt.*;



public class Draw extends Canvas {
    
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");
    Image grassImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Weed.png");

    public void paint(Graphics g){
        
        for(int x = 0; x < screen.width; x+=100){
            for(int y = 0; y < screen.height; y+=100){        
                g.drawImage(grassImg, x, y, this);
            }
        }
        
        g.drawImage(ballImg, 140*(screen.width/600), 100*(screen.height/400), this);
    }

    public void render(Graphics g){
        
        g.translate(540, 160);
    }
}
