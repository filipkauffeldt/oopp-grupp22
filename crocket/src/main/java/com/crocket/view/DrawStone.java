package com.crocket.view;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawStone extends JLabel{
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image stoneImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Stone.png");

    public DrawStone(){
        super();
        this.setIcon(new ImageIcon(stoneImg));
    }
}
