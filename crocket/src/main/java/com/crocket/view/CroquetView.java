package com.crocket.view;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

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
