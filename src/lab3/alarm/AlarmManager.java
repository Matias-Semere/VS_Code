package lab3.alarm;

import java.util.Collection;
import java.util.HashMap;
import lab3.time.TimeType;

public class AlarmManager {
  private HashMap<String, AlarmType> map = new HashMap<String, AlarmType>();
  int i = 1;

  public void addAlarm(AlarmType alarm) {
    map.put(alarm.getTime().toString(), alarm);
  }

  public void removeAlarm(AlarmType alarm) {
    map.remove(alarm.getTime().toString());
  }

  public void removeAllAlarms() {
    map.clear();
  }

  public Collection<AlarmType> getAlarms() {
    return map.values();
  }

  public void checkForAlarm(TimeType time) {
    AlarmType alarm = map.get(time.toString());
    if (alarm != null && alarm.isActive()) {
      System.out.print(i++ + ": ");
      alarm.doAlarm();
    }
  }
}
