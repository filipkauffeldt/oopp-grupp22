package com.crocket;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DrawPanel extends JLabel {
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");
    BufferedImage bBallImg;
    BufferedImage rBallImg;

    public DrawPanel(){
        super();
        try{    
        
        bBallImg = ImageIO.read(DrawPanel.class.getResourceAsStream("crocket/assets/textures/BlueBall.png"));
        rBallImg = ImageIO.read(DrawPanel.class.getResourceAsStream("crocket/assets/textures/RedBall.png"));
        }
        catch(Exception e){

        }
        this.setIcon(new ImageIcon(ballImg));
        this.setBounds(1000, 600, 19, 19);
        
    }

    //temp positioning
    public void paint(Graphics g){
        super.paint(g);
        //paintField(g);
        //g.drawImage(ballImg, 1000, 600, this);
        //g.drawImage(bBallImg, xPos, yPos, this);
        //g.drawImage(rBallImg, 300, 600, this);
           
    }
}
