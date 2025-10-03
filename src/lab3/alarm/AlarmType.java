package lab3.alarm;
import lab3.time.TimeType;

public interface AlarmType
  {
  public void setActive(boolean active);
  public boolean isActive();
  public TimeType getTime();
  public void doAlarm();
  }
