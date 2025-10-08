package lab3.controller;

import lab3.clock.*;
import lab3.time.*;

import javax.swing.*;


public class ClockController extends MainController {

    WeekAlarmClock WAC;
    Timer tid;

    public ClockController(WeekAlarmClock connector) {
        super(connector);
        WAC = connector;
    }
    
    public void startClock() {
        WAC.startTick();
    }

    public void stopClock() {
        WAC.stopTick();   
    }
    
    public String toString() {
        return WAC.toString();
    }
    
    public TimeType getTime() {
        return WAC.getTime();
    }

    public void resetClock() {
        super.setTime(super.getRealTime());
    }

    public void SkickaVidare(Runnable jobb) {
        WAC.läggTillListan(jobb);
    }

    public void setTime(int day, int hour, int minute, int second) {
        WAC.setTime(new Time(day ,hour, minute, second));
    }
}