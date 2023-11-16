package com.crocket;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DrawPanel extends JLabel{
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");

    public DrawPanel(){
        super();
        this.setIcon(new ImageIcon(ballImg));
    }

    //temp positioning
    public void paint(Graphics g){
        super.paint(g);
        
    }

}
