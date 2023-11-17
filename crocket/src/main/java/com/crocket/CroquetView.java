package com.crocket;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/*
 * Class: CroquetView
 * 
 * This class extends JFrame and represents the main window of the game. It is responsible for 
 * rendering the game state to the user.
 * 
 * CroquetView is implemented as a Singleton, ensuring that only one instance of CroquetView exists
 * in the application at any time. This is done to maintain a consistent view state throughout
 * the application.
 * 
 * Methods:
 * - drawLevel(LevelView drawLevel): Adds the provided LevelView to the JFrame, effectively drawing the level.
 * - removeAllLevelComponents(): Removes all LevelView components from the JFrame.
 * - getInstance(): Returns the singleton instance of CroquetView.
 * 
 */

public class CroquetView extends JFrame{
    private static CroquetView INSTANCE = new CroquetView();
    private ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    private String title = "Krocket";
    public DrawEntity entity = new DrawEntity();

    public void drawLevel(LevelView level){
        removeAllLevelComponents();
        add(level);
        level.add(entity);
    }

    private void removeAllLevelComponents(){
        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof LevelView) {
                this.remove(component);
            }
        }
    }

    private CroquetView(){

        setIconImage(img.getImage());
        setTitle(title);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
        entity.setBounds(1000, 600, 19, 19);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static CroquetView getInstance(){
        return INSTANCE;
    }

    public DrawEntity getEntity(){
        return entity;
    }
    
}
