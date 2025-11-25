package ui;

import Feeds.EnvironmentalSystem;

import javax.swing.*;
import java.awt.*;

public class PollutionPanel extends JPanel {
    private EnvironmentalSystem es;

    public PollutionPanel(EnvironmentalSystem es){
        this.es = es;

        this.setLayout(new GridLayout(1,3));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // --- POLLUTION NAME LABEL ---
        JLabel pollName = new JLabel();
        pollName.setText("Pollution:");
        this.add(pollName);


        // --- POLLUTION VALUE LABEL ---
        JLabel pollValueLabel = new JLabel();
        double pollValue = es.getPollutionFeed().getPollution();
        pollValueLabel.setText("Pollution Value:" + pollValue + " ug/m^3");
        this.add(pollValueLabel);


        // --- AIR PURIFIER STATUS LABEL ---
        JLabel airPurifierStatusLabel = new JLabel();
        String airPurifierStatus;
        if (es.isAirPurifierOn() == true){
            airPurifierStatus = "on";
        } else {
            airPurifierStatus = "off";
        }
        airPurifierStatusLabel.setText("Purifier is " + airPurifierStatus);
        this.add(airPurifierStatusLabel);








    }


}
