package lab3.controller;

import lab3.clock.WeekAlarmClock;
import lab3.view.*;

import javax.swing.*;
import java.awt.*;

public class MainController {

    WeekAlarmClock WAC;
    MainFrame view;
    Timer tid;

    public MainController(WeekAlarmClock connector, MainFrame MF) {
        WAC = connector;
        view = MF;
        tid = new Timer(1000, _ -> {WAC.tickTack(); view.refresh();});
    }
    
    public void startTime() {
        tid.start();
    }

    public void stopTime() {
        tid.stop();
    }

    public String toString() {
       return WAC.toString();
    }
    
    

    
}
