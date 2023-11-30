package com.crocket;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DrawBall extends JLabel{
    
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");

    public DrawBall(){
        super();
        this.setIcon(new ImageIcon(ballImg));
    }
}
