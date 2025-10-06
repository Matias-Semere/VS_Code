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
        int[] split = new int[4];
        split[0] = a.getDayOfMonth() + 1 % 7;
        split[1] = a.getHour();
        split[2] = a.getMinute();
        split[3] = a.getSecond();
        return new Time(split[0], split[1], split[2], split[3]);
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
