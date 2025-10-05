package lab3.view;

import java.awt.*;
import javax.swing.*;
import lab3.controller.*;

public class MainFrame extends JFrame {

    MainController mainc; 
    ClockController clockc;
    AlarmController alarmc;

    AlarmsAndButtons AAB;
    ClockAndButtons CAB;

    public MainFrame(MainController mainc, AlarmController alarmc, ClockController clockc) {
        this.mainc = mainc;
        this.alarmc = alarmc;
        this.clockc = clockc;
        mainc.setView(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        mainc.startTime();

        AAB = new AlarmsAndButtons(alarmc);
        CAB = new ClockAndButtons(clockc);

        add(new AnalogClock(clockc), BorderLayout.WEST);
        add(AAB, BorderLayout.CENTER);
        add(CAB, BorderLayout.SOUTH);
    }    

    public void refresh() {
        revalidate();
        repaint();
    }
}
