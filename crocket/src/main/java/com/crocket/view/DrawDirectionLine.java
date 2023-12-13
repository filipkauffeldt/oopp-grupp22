package com.crocket.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawDirectionLine extends JPanel {
    
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private final int STARTX = 50;
    private final int STARTY = 50;
    private final int LINE_COEFFICIENT = 1000;
    private int endX;
    private int endY;

    DrawDirectionLine() {
        super();
        setOpaque(false);
    }

    public void changeAngle(double x, double y) {
        endX = (int)(LINE_COEFFICIENT * x);
        endY = (int)(LINE_COEFFICIENT * y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(STARTX, STARTY, endX, endY);
        
    }
}
