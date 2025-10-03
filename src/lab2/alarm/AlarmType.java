package lab2.alarm;
import lab2.time.TimeType;

public interface AlarmType
  {
  public void setActive(boolean active);
  public boolean isActive();
  public TimeType getTime();
  public void doAlarm();
  }
