package lab3.counter;

public abstract class CircularCounter implements CounterType {
    protected enum Direction { INCREASING, DECREASING }

    protected int currentCount;
    protected final int MAX_NR_OF_COUNTS;
    private boolean isPaused;
    private Direction direction;
    private CounterType nextCounter;

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

    public String toString() {
        return (currentCount < 10 && MAX_NR_OF_COUNTS != 7) ? "0" + currentCount : "" + currentCount;
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
}
