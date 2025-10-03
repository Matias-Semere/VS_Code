package lab1;

public abstract class CircularCounter implements CounterType {
    enum Direction { INCREASING, DECREASING }

    private int currentCount;
    private boolean isPaused;
    private final int MAX_NR_OF_COUNTS;
    private Direction direction;
    private CounterType nextCounter;
    // protected String[] veckodagar = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};


    public CircularCounter(int maxNrOfCounts, Direction direction, CounterType nextCounter) {
        this.direction = direction;
        this.nextCounter = nextCounter;

        if (maxNrOfCounts < 2)
            MAX_NR_OF_COUNTS = 0;
        else
            MAX_NR_OF_COUNTS = maxNrOfCounts;

        if (this.direction == Direction.DECREASING && MAX_NR_OF_COUNTS > 0)
            currentCount = MAX_NR_OF_COUNTS - 1;
        else
            currentCount = 0;
    }

    public int getCount() {
        return currentCount;
    }

    public void reset() {
        if (direction == Direction.INCREASING)
            currentCount = 0;
        else
            currentCount = MAX_NR_OF_COUNTS - 1;
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public void changeDir() {
        direction = (direction == Direction.INCREASING) ? Direction.DECREASING : Direction.INCREASING;
    }

    public void count() {
        if (!isPaused && MAX_NR_OF_COUNTS > 0) {
            if (direction == Direction.INCREASING) {
                currentCount++;
                if (currentCount >= MAX_NR_OF_COUNTS) {
                    currentCount = 0;
                    if (nextCounter != null) {
                        nextCounter.count(); // Ripple effect!
                    }
                }
            } else if (direction == Direction.DECREASING) {
                currentCount--;
                if (currentCount < 0) {
                    currentCount = MAX_NR_OF_COUNTS - 1;
                    if (nextCounter != null) {
                        nextCounter.count();
                    }
                }
            }
        }
    }

    public String toString() {
        return (currentCount < 10 && MAX_NR_OF_COUNTS != 7) ? "0" + currentCount : "" + currentCount;
    }

    // public String getDay() {
    //     if (MAX_NR_OF_COUNTS != 7) {
    //         return "Not a day counter";
    //     }
    //     return veckodagar[currentCount];
    // }
}
