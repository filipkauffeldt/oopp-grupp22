package com.crocket.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawDirectionLine extends JPanel {
    
    private final int width = 100;
    private final int height = 100;
    private int startX = 50;
    private int startY = 50;
    private int endX;
    private int endY;

    DrawDirectionLine(){
        super();
        setOpaque(false);
        
    }

    public void changeAngle(double x, double y){
        endX = (int)(x * 10000);
        endY = (int)(y * 10000);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
