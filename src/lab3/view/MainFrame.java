package lab3.view;

import java.awt.*;
import javax.swing.*;

import lab3.controller.*;
import lab3.clock.*;
// import lab3.time.*;

public class MainFrame extends JFrame {

    MainController mainc; 
    ClockController clockc;
    AlarmController alarmc;

    AlarmsAndButtons AAB;
    ClockAndButtons CAB;

    JPanel panel = new JPanel();

    String[] dagar = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};

    public MainFrame(WeekAlarmClock connector) {
        mainc = new MainController(connector, this);
        clockc = new ClockController(connector);
        alarmc = new AlarmController(connector);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        // setBackground(Color.ORANGE);
        setLayout(new BorderLayout());

        AAB = new AlarmsAndButtons(alarmc);
        CAB = new ClockAndButtons(clockc);
        add(new AnalogClock(), BorderLayout.WEST);

        add(AAB, BorderLayout.NORTH);
        add(CAB, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);
        mainc.startTime();
    }
    
    public void refresh() {
        CAB.add(new JLabel(clockc.toString()));
    }



}
