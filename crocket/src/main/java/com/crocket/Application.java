package com.crocket;
import java.awt.Color;
import javax.swing.*; 

public class Application {
    public static void main( String[] args )
    {
        init(); 
    }
    private static void init(){
        JFrame frame = new JFrame("Crocket");

        //This should be view
        ImageIcon img = new ImageIcon("crocket/assets/textures/JFrame_Icon.jpg");
        frame.setIconImage(img.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);  
    }

}
