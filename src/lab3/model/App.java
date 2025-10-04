package lab3.model;

import javax.swing.SwingUtilities;
import lab3.clock.WeekAlarmClock;
import lab3.controller.*;
import lab3.view.*;

public class App {
    public static void main(String[] args) {
        WeekAlarmClock clock = new WeekAlarmClock();

        MainController mainc = new MainController(clock);
        AlarmController alarmc = new AlarmController(clock);
        ClockController clockc = new ClockController(clock);

        System.out.println("App started");

        SwingUtilities.invokeLater(() -> new MainFrame(mainc, alarmc, clockc).setVisible(true));
    }
}