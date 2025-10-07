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
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        JTabbedPane tabbedPane = new JTabbedPane();
        JTabbedPane tabbedPan2 = new JTabbedPane();

        tabbedPane.addTab("Dgital", CAB);
        tabbedPane.addTab("Clock", new AnalogClock(clockc));
        tabbedPane.setBackground(Color.ORANGE);
        
        tabbedPan2.addTab("Alarm", AAB);
        
        add(tabbedPane);
        // add(tabbedPan2, BorderLayout.EAST);
        add(AAB);

    }    

    public void repaintCAB() {
        CAB.revalidate();
        CAB.repaint();
    }

}
