package lab3.controller;

import lab3.clock.*;

import java.util.Collection;

import lab3.alarm.*;
import lab3.time.*;

public class AlarmController {
    
    WeekAlarmClock WAC;


    public AlarmController(WeekAlarmClock connector) {
        WAC = connector;
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

    public String getAlarm(TimeType tid) {
        String svar = "";
        if(getAlarms().size() == 0) System.out.println("Inget i alarm listan");
        else {
            for (AlarmType ettAlarm : getAlarms()) {
                svar += ettAlarm.toString();
            }
        }
        return svar;
    }

}
