
package com.crocket.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PowerPanel extends JPanel {
    
    private ImageIcon powerImg = new ImageIcon("crocket/assets/textures/PowerMeter.png");
    private JLabel powerLabel = new JLabel();
    private int[] x = new int[] {0,3,6};
    private int[] y = new int[] {55,25,55};
    
    PowerPanel(){
        super();
        powerLabel.setIcon(powerImg);
        add(powerLabel);
        setOpaque(false);
        setLocation(100, 100);
        setVisible(false);
    }

    public void resetIndicator(){
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
    public void paintChildren(Graphics g){
        super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        g2.fillPolygon(x, y, 3);
    }
}
