package com.crocket;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawDirectionLine extends JPanel {
    
    private int startX = 50;
    private int startY = 50;
    private int endX;
    private int endY;

    DrawDirectionLine(){
        super();
        setOpaque(false);
        
        
    }
    
    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public void changeAngle(int x, int y){
        endX = x;
        endY = y;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(startX, startY, endX, endY);
        
    }
}
