package lab3.model;

import javax.swing.SwingUtilities;
import lab3.clock.WeekAlarmClock;
import lab3.view.*;

public class App {
    public static void main(String[] args) {
        WeekAlarmClock clock = new WeekAlarmClock();

        SwingUtilities.invokeLater(() -> new MainFrame(clock).setVisible(true));
    }
}