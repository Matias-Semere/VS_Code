package lab3.controller;

import lab3.clock.*;

import java.util.*;

import lab3.alarm.*;
import lab3.time.*;

public class AlarmController {
    
    WeekAlarmClock WAC;

    public AlarmController(WeekAlarmClock connector) {
        WAC = connector;
    }

    public void görDetta(Runnable Detta) {
        WAC.skaGöraEfterNotis(Detta);
    }

    public void addAlarm(TimeType tid) {
        WAC.addAlarm(new Alarm(tid));   
    }

    public void removeAlarm(TimeType tid) {
        WAC.removeAlarm(new Alarm(tid));   
    }

    public void removeAllAlarms() {
        WAC.removeAllAlarms();
    }

    public Collection<AlarmType> getAlarms() {
        return WAC.getAlarms();
    }

    public AlarmType getAlarm(TimeType tid) {
        if(getAlarms().size() == 0) System.out.println("Inget i alarm listan");
        else {
            for (AlarmType ettAlarm : getAlarms()) {
                if(ettAlarm.toString().equals(tid.toString())) return ettAlarm;
            }
        }
        return null;
    }

    public void setActive(AlarmType alarm, boolean aktiv) {
        if(alarm != null) alarm.setActive(aktiv);
    }

    public boolean isActive(AlarmType alarm) {
        if(alarm != null) return alarm.isActive();
        return false;
    }

}
