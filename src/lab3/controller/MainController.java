package lab3.controller;

import javax.swing.*;
import lab3.clock.WeekAlarmClock;
import lab3.view.MainFrame;

public class MainController {

    WeekAlarmClock WAC;
    MainFrame view;
    Timer tid;

    public MainController(WeekAlarmClock connector) {
        WAC = connector;
        tid = new Timer(1000, e -> {WAC.tickTack(); view.refresh();});
    }
    public void setView(MainFrame view) {
        this.view = view;
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
