package ui;

import Feeds.EnvironmentalSystem;

import javax.swing.*;
import java.awt.*;

public class HumidityPanel extends JPanel {

    private EnvironmentalSystem es;


    public HumidityPanel(EnvironmentalSystem es) {


        this.es = es;

        this.setLayout(new GridLayout(1, 5));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // --- HUMIDITY NAME LABEL ---
        JLabel humidityName = new JLabel();
        humidityName.setText("Humidity");

        this.add(humidityName);

        // --- INSIDE HUMIDITY VALUE ---
        JLabel insideHumidityLabel = new JLabel();
        double insideHumidityValue = es.getHumidityFeed().getInsideHumidity();
        insideHumidityLabel.setText("Inside Humidity: " + insideHumidityValue);

        this.add(insideHumidityLabel);

        // --- OUTSIDE HUMIDITY VALUE ---
        JLabel outsideHumidityLabel = new JLabel();
        double outsideHumidityValue = es.getHumidityFeed().getOutsideHumidity();
        outsideHumidityLabel.setText("Outside Humidity: " + outsideHumidityValue);

        this.add(outsideHumidityLabel);


        // --- DIFFERNEC HUMIDITY VALUE ---
        JLabel diffHumidityLabel = new JLabel();
        double diffHumidityValue = (outsideHumidityValue- insideHumidityValue)/outsideHumidityValue *100;
        diffHumidityLabel.setText("Difference Humidity: " + Math.round(diffHumidityValue*10)/10.0 + "%");

        this.add(diffHumidityLabel);

        // --- DEHUMIDIFER STATUS LABEL ---
        JLabel dehumidiferStatusLabel = new JLabel();
        String dehumidiferStatus;
        if (es.isDehumudifierOn() == true){
            dehumidiferStatus = "on";
        } else {
            dehumidiferStatus = "off";
        }
        dehumidiferStatusLabel.setText("Dehumidifier is " + dehumidiferStatus);
        this.add(dehumidiferStatusLabel);







    }
}
