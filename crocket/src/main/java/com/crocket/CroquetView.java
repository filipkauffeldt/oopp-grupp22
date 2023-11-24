package com.crocket;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CroquetView extends JFrame{
    JFrame frame;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    DrawBall ball1 = new DrawBall();
    DrawField field = new DrawField();
    ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    String title = "Krocket";
    boolean visibility = true;

    CroquetView(){
        frame = new JFrame();

        setIconImage(img.getImage());
        setTitle(title);
        setVisible(visibility); 
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
       
        add(field);
        field.setBounds(0, 0, (int)screen.getWidth(), (int)screen.getHeight());;
        field.add(ball1);
        ball1.setBounds(1000, 600, 19, 19);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void moveBall(int xPos, int yPos){
        ball1.setLocation(xPos,yPos);
    }
}
