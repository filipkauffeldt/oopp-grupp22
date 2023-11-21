package com.crocket;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;

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
    private static CroquetView instance;
    private ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    private String title = "Krocket";
    private DrawEntity entity;
    private LevelView levelView;
    
    public void setLevelView(LevelView level) {
        if (getContentPane() != null) {
            getContentPane().removeAll();
        }
        this.levelView = level;
        add(level);
        revalidate();
    }

    public void setBallToLevel(DrawEntity ball){
        try{
            this.entity = ball;
            levelView.add(ball);
        }
        catch(NullPointerException e){
            System.out.println("No container found!");
        }
    }

    private CroquetView(){

        setIconImage(img.getImage());
        setTitle(title);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static CroquetView getInstance(){
        if (instance == null) {
            instance = new CroquetView();
            
        }
        return instance;
    }

    public DrawEntity getEntity(){
        return entity;
    }

    public void moveBall(int x, int y){
        entity.setLocation(x, y);
    }

}
