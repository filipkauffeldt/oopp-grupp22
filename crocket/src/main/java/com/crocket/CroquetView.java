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
 * setLevelView: Sets the current level view to the specified LevelView object. Clears the frame
 * setBallToLevel: Sets the ball to the specified DrawEntity object.
 * 
 * 
 * Problems:
 * CroquetView can only have one DrawEntity object at a time. Might be problems later on when we add multiplayer. 
 * 
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
    JFrame frame;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    DrawEntity entity = new DrawEntity();
    DrawField field = new DrawField();
    DrawStone stone = new DrawStone();
    ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
    String title = "Krocket";
    boolean visibility = true;

    CroquetView(){
        frame = new JFrame();

        setIconImage(img.getImage());
        setTitle(title);
        setVisible(true);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH); 
       
        add(field);
        field.setBounds(0, 0, (int)screen.getWidth(), (int)screen.getHeight());;
        field.add(entity);
        entity.setBounds(1000, 600, 19, 19);
        
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
