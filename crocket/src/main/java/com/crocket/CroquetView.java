package com.crocket;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CroquetView extends JFrame{
    JFrame frame;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();


    public void drawLevel(LevelView drawLevel){
        removeAllLevelComponents();
        add(drawLevel);
    }

    private void removeAllLevelComponents(){
        Component[] components = frame.getComponents();
        for (Component component : components) {
            if (component instanceof LevelView) {
                frame.remove(component);
            }
        }
    }

    CroquetView(){
        frame = new JFrame();

        setIconImage(img.getImage());
        setTitle(title);
        setVisible(visibility); 
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 

        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
