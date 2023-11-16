package com.crocket;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DrawPanel extends JLabel implements KeyListener{
    
    //temp placement
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Image ballImg = Toolkit.getDefaultToolkit().getImage("crocket/assets/textures/Ball.png");
    BufferedImage bBallImg;
    BufferedImage rBallImg;

    public DrawPanel(){
        super();
        try{    
        
        bBallImg = ImageIO.read(DrawPanel.class.getResourceAsStream("crocket/assets/textures/BlueBall.png"));
        rBallImg = ImageIO.read(DrawPanel.class.getResourceAsStream("crocket/assets/textures/RedBall.png"));
        }
        catch(Exception e){

        }
        this.setIcon(new ImageIcon(ballImg));
        this.setBounds(1000, 600, 19, 19);
        this.addKeyListener(this);
        
    }

    //temp positioning
    public void paint(Graphics g){
        super.paint(g);
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            setLocation((int)screen.getWidth()/2, (int)screen.getHeight()/2);
            repaint();
            System.out.println("Hej");
        }
    }

    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
