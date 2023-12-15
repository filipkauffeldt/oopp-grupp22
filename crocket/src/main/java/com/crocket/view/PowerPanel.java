
package com.crocket.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PowerPanel extends JPanel {
    
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private ImageIcon powerImg = new ImageIcon("crocket/assets/textures/PowerMeter.png");
    private JLabel powerLabel = new JLabel();
    private final int WIDTH = 200;
    private final int HEIGHT = 50;
    private final int XPOS = (int) screen.getWidth()/100;
    private final int YPOS = 85 * (int) screen.getHeight()/100;
    private int[] x = new int[] {0,3,6};
    private int[] y = new int[] {55,0,55};
    
    PowerPanel() {
        super();
        powerLabel.setIcon(powerImg);
        add(powerLabel);
        setOpaque(false);
        setLocation(100, 100);
    }
    
    public int getXPOS() {
        return XPOS;
    }

    public int getYPOS() {
        return YPOS;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void resetIndicator() {
        x[0] = 0;
        x[1] = 3;
        x[2] = 6;
    }
    
    public void incrementIndicator() {
        for(int i = 0; i < x.length; i++){
            x[i] += 5;
        }
    }

    public void decrementIndicator() {
        for(int i = 0; i < x.length; i++){
            x[i] -= 5;
        }
    }

    @Override
    public void paintChildren(Graphics g) {
        super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        g2.fillPolygon(x, y, 3);
    }
}
