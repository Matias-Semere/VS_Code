package lab3.controller;

import java.time.LocalDateTime;

import javax.swing.*;
import lab3.clock.WeekAlarmClock;
import lab3.view.MainFrame;
import lab3.time.*;

public class MainController {

    WeekAlarmClock WAC;
    MainFrame view;
    Timer tid;

    public MainController(WeekAlarmClock connector) {
        WAC = connector;
    }

    public TimeType getRealTime() {
        LocalDateTime a = WAC.realTime();
        return new Time(a.getDayOfMonth() + 1 % 7, a.getHour(), a.getMinute(), a.getSecond());
    }

    public  void setTime(TimeType time) {
        WAC.setTime(time);
    }

    public void setView(MainFrame view) {
        this.view = view;
        tid = new Timer(1000, e -> {WAC.tickTack(); view.repaintCAB();});
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
