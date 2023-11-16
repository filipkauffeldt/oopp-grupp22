package com.crocket;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;


public class CroquetView extends JFrame{
    JFrame frame;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    DrawPanel draw = new DrawPanel();
    DrawField df = new DrawField();

    CroquetView(){
        frame = new JFrame();

        ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
        setIconImage(img.getImage());
        setTitle("Krocket");
        setVisible(true); 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
       
        add(df);
        df.setBounds(0, 0, (int)screen.getWidth(), (int)screen.getHeight());;
        df.add(draw);
        draw.setBounds(1000, 600, 19, 19);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
