package com.crocket;
import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
 * setLevelView: Sets the current level view to the specified LevelView object. Clears the frame
 * setBallToLevel: Sets the ball to the specified DrawEntity object.
 * 
 * 
 * Problems:
 * CroquetView can only have one DrawEntity object at a time. Might be problems later when we add multiplayer. 
 * 
 * 
 */

public class CroquetView extends JFrame{
    private static CroquetView instance;
    private ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private String title = "Krocket";
    private DrawBall ball;
    private LevelView levelView;
    private DrawStone stone;
    DrawDirectionLine line = new DrawDirectionLine();
    PowerPanel pPanel = new PowerPanel();
    
    
    
    public void setLevelView(LevelView level) {
        if (getContentPane() != null) {
            getContentPane().removeAll();
        }
        this.levelView = level;
        add(level);
        revalidate();
    }

    public void setBallToLevel(DrawBall ball){
        try{
            this.ball = ball;
            levelView.add(ball);
            levelView.add(line);
            levelView.add(pPanel);
            
        }
        catch(NullPointerException e){
            System.out.println("No container found!");
        }
    }

    public void setStoneToLevel(DrawStone stone){
        try{
            this.stone = stone;
            levelView.add(stone);
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

    public DrawBall getEntity(){
        return ball;
    }

    public void setStone(int x, int y){
        stone.setLocation(x, y);
    }

    public void moveBall(int x, int y){
        ball.setLocation(x, y);
    }

    public void setPowerMeterVisibility(boolean vis){
        pPanel.setVisible(vis);
    }

    public void incrementIndicator(){
        pPanel.incrementIndicator();
        pPanel.repaint();
    }

    public void decrementIndicator(){
        pPanel.decrementIndicator();
        pPanel.repaint();
    }

    public void resetIndicator(){
        pPanel.resetIndicator();
        pPanel.repaint();
    }

    public void updateLine(int xPos, int yPos, int xAngle, int yAngle){
        line.setSize(100, 100);
        line.setLocation(xPos-line.getStartX(), yPos-line.getStartY());
        line.changeAngle(xAngle + (line.getStartX()), yAngle + (line.getStartY()));
        line.repaint();
    }

    public void updatePowerMeter(){
        pPanel.setLocation(30, (int)screen.getHeight() - 100);
    }

}
