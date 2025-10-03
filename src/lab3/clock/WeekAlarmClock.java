package lab3.clock;

import java.util.Collection;

import lab3.alarm.*;
import lab3.counter.*;
import lab3.time.*;

public class WeekAlarmClock implements AlarmClockType  {
    SettableCounterType day = new Counter7();
    SettableCounterType hour = new Counter24(day);
    SettableCounterType minute = new Counter60(hour);
    SettableCounterType second = new Counter60(minute);
    
    AlarmManager alarman = new AlarmManager();

    public void tickTack() {
        second.count();
        alarman.checkForAlarm(getTime());
    }

    public void setTime(TimeType time) {
        day.setCount(time.getDay());
        hour.setCount(time.getHour());
        minute.setCount(time.getMinute());
        second.setCount(time.getSecond());
    }

    public String toString() {
        return getTime().toString();  
    }
    
    public TimeType getTime() {
        return new Time(day.getCount(),hour.getCount(), minute.getCount(), second.getCount());
    }

    //Alla metoder under deligerar allarmanager alltså skickar vidare
    
    public void addAlarm(AlarmType alarm) {
        alarman.addAlarm(alarm);
    }

    public void removeAlarm(AlarmType alarm) {
        alarman.removeAlarm(alarm);
    }

    public void removeAllAlarms() {
        alarman.removeAllAlarms();
    }

    public Collection<AlarmType> getAlarms() {
        return alarman.getAlarms();
    }

}
