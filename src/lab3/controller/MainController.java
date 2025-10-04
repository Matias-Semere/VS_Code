package lab3.controller;

import javax.swing.*;
import lab3.clock.WeekAlarmClock;
import lab3.view.*;

public class MainController {

    WeekAlarmClock WAC;
    // MainFrame view;
    Timer tid;

    public MainController(WeekAlarmClock connector) {
        WAC = connector;
        tid = new Timer(1000, e -> {WAC.tickTack();});
    }

    // public void setView(MainFrame MF) {
    //     view = MF;
    // }
    public void startTime() {
        tid.start();
        // view.refersh();
    }

    public void stopTime() {
        tid.stop();
    }

    public String toString() {
       return WAC.toString();
    }
    
    

    
}
