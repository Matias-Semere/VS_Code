package lab2.clock;

import static org.junit.Assert.*;

import org.junit.Test;
import lab2.alarm.*;
import lab2.time.*;

public class WeekAlarmClockTest {
    
    @Test
    public void testTickTack() {
        WeekAlarmClock clocka = new WeekAlarmClock();
        
        clocka.tickTack();

        assertEquals(1, clocka.getTime().getSecond());
    }

    @Test 
    public void testRollOver(){
        WeekAlarmClock clocka = new WeekAlarmClock();
        for (int i = 0; i < 59; i++) {
            assertEquals(i, clocka.getTime().getSecond());
            clocka.tickTack();
        }
        
        clocka.tickTack();
        assertEquals(0, clocka.getTime().getSecond());
    }

    @Test 
    public void testSetTime() {
        WeekAlarmClock clocka = new WeekAlarmClock();

        Time time = new Time(3, 14, 15, 9);

        clocka.setTime(time);

        assertEquals(time.toString(), clocka.toString());
    }

    @Test 
    public void testaddAlarm() {
        WeekAlarmClock clocka = new WeekAlarmClock();
        Alarm alarm = new Alarm(new Time(0,1,0,0));
        Alarm alarm2 = new Alarm(new Time(0,2,0,0));

        clocka.addAlarm(alarm);
        clocka.addAlarm(alarm2);
        
        for (int i = 0; i < 60*61; i++) {
            clocka.tickTack();
        }

        clocka.setTime(new Time(0,1,59,59));

        System.out.println("-----");
        clocka.tickTack();
    }

    @Test
    public void testRemoveAlarm() {
        WeekAlarmClock clocka = new WeekAlarmClock();
        Alarm alarm = new Alarm(new Time(0,1,0,0));
        Alarm alarm2 = new Alarm(new Time(0,2,0,0));

        clocka.addAlarm(alarm);
        clocka.addAlarm(alarm2);

        clocka.removeAlarm(alarm);

        clocka.setTime(new Time(0,0,59,59));
        clocka.tickTack();
        clocka.setTime(new Time(0,1,59,59));
        clocka.tickTack();


    }

    @Test
    public void testRemoveAllAlarms() {
        WeekAlarmClock clocka = new WeekAlarmClock();
        Alarm alarm = new Alarm(new Time(0,1,0,0));
        Alarm alarm2 = new Alarm(new Time(0,2,0,0));

        clocka.addAlarm(alarm);
        clocka.addAlarm(alarm2);

        clocka.removeAllAlarms();

        clocka.setTime(new Time(0,0,59,59));
        clocka.tickTack();
        clocka.setTime(new Time(0,1,59,59));
        clocka.tickTack();
    }

}
