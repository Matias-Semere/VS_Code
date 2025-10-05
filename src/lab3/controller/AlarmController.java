package lab3.controller;

import java.util.*;

import lab3.clock.*;
import lab3.alarm.*;
import lab3.time.*;

public class AlarmController {

    WeekAlarmClock WAC;

    public AlarmController(WeekAlarmClock connector) {
        WAC = connector;
    }

    public void görDetta(Runnable Detta) {
        WAC.läggTillListan(Detta);
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
        if (getAlarms().size() == 0);
        else {
            for (AlarmType ettAlarm : getAlarms()) {
                if (ettAlarm.toString().equals(tid.toString()))
                    return ettAlarm;
            }
        }
        return null;
    }

    public void setActive(TimeType tid, boolean aktiv) {
        AlarmType alarm = getAlarm(tid);
        if (alarm != null)
            getAlarm(tid).setActive(aktiv);
    }

    public boolean isActive(AlarmType alarm) {
        if (alarm != null)
            return alarm.isActive();
        return false;
    }

    public String toString(AlarmType alarm) {
        return isActive(alarm) ? " Aktiv" : " Inaktiv";
    }

    public boolean checkIfAlarm() {
        if (getAlarm(WAC.getTime()) != null) {
            if (isActive(getAlarm(WAC.getTime())))
            return true;
        }
        return false;
    }

}
