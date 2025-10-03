package lab3.counter;

public class SettableCounter extends CircularCounter implements SettableCounterType {

  public SettableCounter(int max, Direction direction, CounterType nextCounter) {
    super(max, direction, nextCounter);
  }

  @Override
  public void setCount(int value) {
    if (0 <= value && value < MAX_NR_OF_COUNTS)
      currentCount = value;
    else System.out.println("Måste vara större än noll och mindre än " + MAX_NR_OF_COUNTS);
    }
}