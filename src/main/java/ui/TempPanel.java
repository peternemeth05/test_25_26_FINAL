package ui;

import Feeds.EnvironmentalSystem;


import javax.swing.*;
import java.awt.*;

public class TempPanel extends JPanel {

    private EnvironmentalSystem es;


    public TempPanel(EnvironmentalSystem es){


        this.es = es;

        this.setLayout(new GridLayout(1,4));
        //this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // --- TEMP NAME LABEL ---
        JLabel tempName = new JLabel();
        tempName.setText("Temperature:");

        this.add(tempName);

        // --- NORTH WARD (0) INFO ---

        JLabel northTempInfo = new JLabel();
        double curNorthTemp = Math.round(es.getTempFeed().getTemperature(0)*10)/10.0;
        double idealNorthTemp = 23;
        String heatingStatusN;
        if (es.isHeatingOn(0) == true){
             heatingStatusN = "on";
        } else {
            heatingStatusN = "off";
        }

        northTempInfo.setText("<html> North Ward <br>Current Temp: " + (curNorthTemp)  +"<br>"+ idealNorthTemp +"<br>Heater is "+ heatingStatusN +"</html>");

        this.add(northTempInfo);

        // --- CENTRAL WARD (1) INFO ---

        JLabel centralTempInfo = new JLabel();
        double curCentralTemp = Math.round(es.getTempFeed().getTemperature(1)*10)/10.0;
        double idealCentralTemp = 23;
        String heatingStatusC;
        if (es.isHeatingOn(1) == true){
            heatingStatusC = "on";
        } else {
            heatingStatusC = "off";
        }

        centralTempInfo.setText("<html> Central Ward <br>Current Temp: " + curCentralTemp  +"<br>"+ idealCentralTemp +"<br>Heater is "+ heatingStatusC +"</html>");

        this.add(centralTempInfo);

        // --- SOUTH WARD (2) INFO ---

        JLabel southTempInfo = new JLabel();
        double curSouthTemp = Math.round(es.getTempFeed().getTemperature(2)*10)/10.0;
        double idealSouthTemp = 23;
        String heatingStatusS;
        if (es.isHeatingOn(2) == true){
            heatingStatusS = "on";
        } else {
            heatingStatusS = "off";
        }

        southTempInfo.setText("<html> South Ward <br>Current Temp: " + curSouthTemp  +"<br>"+ idealSouthTemp +"<br>Heater is "+ heatingStatusS +"</html>");

        this.add(southTempInfo);

        // if the temp is greater and heater is on
        if((curSouthTemp-idealSouthTemp) > 0.5 && es.isHeatingOn(2) == true){
            this.setBackground(Color.red);
            es.turnHeatingOn(2,false);

        } else if((curSouthTemp-idealSouthTemp) > -0.5 && es.isHeatingOn(2) == false)  {
            this.setBackground(Color.red);
            es.turnHeatingOn(2,true);
        } else{
            this.setBackground(Color.white);
        }

        if((curNorthTemp-idealNorthTemp) > 0.5 && es.isHeatingOn(0) == true){
            this.setBackground(Color.red);
            es.turnHeatingOn(0,false);

        } else if((curNorthTemp-idealNorthTemp) > -0.5 && es.isHeatingOn(0) == false)  {
            this.setBackground(Color.red);
            es.turnHeatingOn(0,true);
        } else{
            this.setBackground(Color.white);
        }

        if((curNorthTemp-idealNorthTemp) > 0.5 && es.isHeatingOn(1) == true){
            this.setBackground(Color.red);
            es.turnHeatingOn(1,false);

        } else if((curCentralTemp-idealCentralTemp) > -0.5 && es.isHeatingOn(1) == false)  {
            this.setBackground(Color.red);
            es.turnHeatingOn(1,true);
        } else{
            this.setBackground(Color.white);
        }



    }

}
