package lab3.view;

import java.awt.*;
import javax.swing.*;
import lab3.controller.*;

public class MainFrame extends JFrame {

    MainController mainc;
    ClockController clockc;
    AlarmController alarmc;

    public MainFrame(MainController mainc, AlarmController alarmc, ClockController clockc) {
        this.mainc = mainc;
        mainc.setTime(mainc.getRealTime());
        mainc.startClock();

        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Lab 3");
        add(new ClockAndButtons(clockc));
        add(new AlarmsAndButtons(alarmc));
        pack();
    }

}
