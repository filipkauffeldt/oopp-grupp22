package com.crocket.view;
import javax.swing.JFrame;

import javax.swing.ImageIcon;

public class CroquetView extends JFrame{
    private static CroquetView instance;
    private ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    private String title = "Krocket";
    private LevelView levelView;
    
    public void setLevelView(LevelView level) {
        if (getContentPane() != null) {
            getContentPane().removeAll();
        }
        this.levelView = level;
        add(level);
        revalidate();
    }

    private CroquetView(){
        setIconImage(img.getImage());
        setTitle(title);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static CroquetView getInstance(){
        if (instance == null) {
            instance = new CroquetView();
            
        }
        return instance;
    }

    public void incrementIndicator(){
        levelView.incrementPowerIndicator();
    }

    public void decrementIndicator(){
        levelView.decrementPowerIndicator();
    }

    public void resetIndicator(){
        levelView.resetPowerIndicator();
    }
}
