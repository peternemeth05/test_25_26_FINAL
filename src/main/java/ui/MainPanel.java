package ui;
import Feeds.EnvironmentalSystem;


import javax.swing.*;
import java.awt.*;

public class MainPanel{

    private JPanel mainPanel;

    private HumidityPanel humidityPanel;
    private PollutionPanel pollutionPanel;
    private TempPanel tempPanel;
    private EnvironmentalSystem es;

    public MainPanel(EnvironmentalSystem es){

        this.es =es;

        mainPanel = new JPanel();

        humidityPanel = new HumidityPanel(es);
        pollutionPanel = new PollutionPanel(es);
        tempPanel = new TempPanel(es);


        mainPanel.setLayout(new GridLayout(3,1));

        mainPanel.add(tempPanel);
        mainPanel.add(pollutionPanel);
        mainPanel.add(humidityPanel);




    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public void PanelRepaint(){
        mainPanel.remove(humidityPanel);
        mainPanel.remove(pollutionPanel);
        mainPanel.remove(tempPanel);

        mainPanel.revalidate();

        humidityPanel = new HumidityPanel(es);
        pollutionPanel = new PollutionPanel(es);
        tempPanel = new TempPanel(es);

        mainPanel.add(tempPanel);
        mainPanel.add(pollutionPanel);
        mainPanel.add(humidityPanel);








    }

}
