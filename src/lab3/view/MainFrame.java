package lab3.view;

import java.awt.*;
// import java.time.LocalDateTime;

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
        AAB = new AlarmsAndButtons(alarmc);
        CAB = new ClockAndButtons(clockc);
        
        mainc.setView(this);
        mainc.startTime();
        mainc.setTime(mainc.getRealTime());

        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Dgital", CAB);
        tabbedPane.addTab("Clock", new AnalogClock(clockc));
        tabbedPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        add(tabbedPane);
        add(AAB);

        pack();
    }    

    public void repaintCAB() {
        CAB.revalidate();
        CAB.repaint();
    }

}
