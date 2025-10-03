package lab2.clock;
import java.util.Collection;
import lab2.alarm.AlarmType;
import lab2.time.TimeType;

public interface AlarmClockType
  {
  public void tickTack();
  public void setTime(TimeType time);
  public void addAlarm(AlarmType larm);
  public void removeAlarm(AlarmType alarm);
  public void removeAllAlarms();
  public Collection<AlarmType> getAlarms();
  public TimeType getTime();
  public String toString();
  }
