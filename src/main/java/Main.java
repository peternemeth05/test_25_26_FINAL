import Feeds.*;

import ui.MainPanel;
import ui.TempPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EnvironmentalSystem es = new EnvironmentalSystem();

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("Envriornmental Status");

        MainPanel mainPanel;
        mainPanel = new MainPanel(es);
        frame.add(mainPanel.getMainPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.PanelRepaint();



            }
        });
        timer.start();


    }
}