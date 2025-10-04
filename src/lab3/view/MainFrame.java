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


    public MainFrame(WeekAlarmClock connector) {
        mainc = new MainController(connector, this);
        clockc = new ClockController(connector);
        alarmc = new AlarmController(connector);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        mainc.startTime();

        AAB = new AlarmsAndButtons(alarmc);
        CAB = new ClockAndButtons(clockc);

        add(new AnalogClock(), BorderLayout.WEST);
        add(AAB, BorderLayout.CENTER);
        add(CAB, BorderLayout.SOUTH);

    }
    

}
