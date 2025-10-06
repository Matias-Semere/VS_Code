package lab3.model;

import java.time.LocalDateTime;

import javax.swing.SwingUtilities;
import lab3.clock.WeekAlarmClock;
import lab3.controller.*;
import lab3.view.*;

public class App {
    public static void main(String[] args) {
        WeekAlarmClock clock = new WeekAlarmClock();
        LocalDateTime real = LocalDateTime.now();



        MainController mainc = new MainController(clock);
        AlarmController alarmc = new AlarmController(clock);
        ClockController clockc = new ClockController(clock);

        SwingUtilities.invokeLater(() -> new MainFrame(mainc, alarmc, clockc).setVisible(true));
    }
}