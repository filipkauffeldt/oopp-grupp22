package com.crocket;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DrawEntity extends JLabel{
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");

    public DrawEntity(){
        super();
        this.setIcon(new ImageIcon(ballImg));
    }
}