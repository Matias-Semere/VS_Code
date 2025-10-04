package lab3.time;

import java.util.Arrays;
import java.util.regex.*;

public class Time implements TimeType {
  private int second, minute, hour, day;
  private static final String[] dayNames = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
  private boolean hasDay = false;

  public Time(int hour, int minute, int second) {
    setHour(hour);
    setMinute(minute);
    setSecond(second);
  }

  public Time(int day, int hour, int minute, int second) {
    this(hour, minute, second);
    setDay(day);
  }

  public Time(String time) {
    Pattern p = Pattern.compile("^(?:(Mon|Tue|Wed|Thu|Fri|Sat|Sun) )?(2[0-3]|[01]?\\d):([0-5]?\\d):([0-5]?\\d)$");
    Matcher m = p.matcher(time);

    if(!m.matches()) throw new RuntimeException("Illegal time format: " + time);

    if (m.group(1) != null) {
      setDay(Arrays.asList(dayNames).indexOf(m.group(1)));
    }

    hour = Integer.parseInt(m.group(2));
    minute = Integer.parseInt(m.group(3));
    second = Integer.parseInt(m.group(4));
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second % 60;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute % 60;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour % 24;
  }

  public boolean hasDay() {
    return hasDay;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day % 7;
    hasDay = true;
  }

  public String toString() {
    return hasDay 
      ? String.format("%s %02d:%02d:%02d", dayNames[day], hour, minute, second)
      : String.format("%02d:%02d:%02d", hour, minute, second);
  }
}
