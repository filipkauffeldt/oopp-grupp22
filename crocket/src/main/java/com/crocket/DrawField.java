package com.crocket;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DrawField extends JPanel{
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    Image grassImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Weed.png");
    Image sandImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Anakin.png");
    Image iceImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Nice.png");

    @Override
    public void paintComponent(Graphics g){
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
    }
}


    