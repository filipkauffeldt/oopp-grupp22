package com.crocket;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;


public class CroquetView extends JFrame{
    JFrame frame;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    DrawLevel drawLevel = new DrawLevel(new Level1());

    CroquetView(){
        frame = new JFrame();

        
        ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
        setIconImage(img.getImage());
        setTitle("Krocket");
        setVisible(true); 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
        add(drawLevel);

        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
}
