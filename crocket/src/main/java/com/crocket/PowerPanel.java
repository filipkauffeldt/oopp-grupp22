package com.crocket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PowerPanel extends JPanel {
    
    ImageIcon powerImg = new ImageIcon("crocket/assets/textures/PowerMeter.png");
    JLabel powerLabel = new JLabel();
    
    PowerPanel(){
        super();
        powerLabel.setIcon(powerImg);
        add(powerLabel);
        setOpaque(false);
        setLocation(100, 100);
    }
}
