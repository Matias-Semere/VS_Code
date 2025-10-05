package lab3.controller;

import lab3.clock.*;
import lab3.time.*;

import javax.swing.*;


public class ClockController {

    WeekAlarmClock WAC;
    Timer tid;

    public ClockController(WeekAlarmClock connector) {
        WAC = connector;
    }

    public void SkickaVidare(Runnable jobb) {
        WAC.läggTillListan(jobb);
    }

    public void setTime(int hour, int minute, int second, int day) {
        WAC.setTime(new Time(day ,hour, minute, second));
    }
    
    public String toString() {
        return WAC.toString();
    }

    public void stopClock() {
        WAC.stopTick();   
    }

    public void startClock() {
        WAC.startTick();
    }

    public void resetClock() {
        WAC.setTime(new Time(0, 0, 0, 0));
    }
}