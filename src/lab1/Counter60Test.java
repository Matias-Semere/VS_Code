package lab1;

import static org.junit.Assert.*;
import org.junit.Test;

import lab1.CircularCounter.Direction;

public class Counter60Test {

    @Test
    public void testCountIncreasing() {
        CounterType counter = new Counter60();
        for (int i = 0; i < 60; i++) {
            assertEquals(i, counter.getCount());
            counter.count();
        }
        assertEquals(0, counter.getCount()); // Rolled over
    }

    @Test
    public void testCountDecreasing() {
        CounterType counter = new Counter60(Direction.DECREASING);
        assertEquals(59, counter.getCount());
        for (int i = 0; i < 60; i++) {
            counter.count();
        }
        assertEquals(59, counter.getCount()); // Rolled over from 0 → 59
    }

    @Test
    public void testChaining() {
        CounterType hours = new Counter24();
        CounterType minutes = new Counter60(hours);
        CounterType seconds = new Counter60(minutes);

        for (int i = 0; i < 60; i++) {
            seconds.count();
        }

        assertEquals(1, minutes.getCount());
        assertEquals(0, seconds.getCount());

        for (int i = 0; i < 59; i++) { // 1 hour
            minutes.count();
        }

        assertEquals(1, hours.getCount());
        assertEquals(0, minutes.getCount());
    }

    @Test
    public void testPauseResume() {
        CounterType counter = new Counter60();
        counter.pause();
        for (int i = 0; i < 100; i++) {
            counter.count();
            assertEquals(0, counter.getCount()); // Should remain 0
        }
        counter.resume();
        counter.count();
        assertEquals(1, counter.getCount()); // Should increment now
    }

    @Test
    public void testReset() {
        CounterType counter = new Counter60();
        for (int i = 0; i < 30; i++) {
            counter.count();
        }
        assertEquals(30, counter.getCount());
        counter.reset();
        assertEquals(0, counter.getCount());
    }

    @Test 
    public void testChangeDirection() {
        CounterType counter = new Counter60();
        for (int i = 0; i < 10; i++) {
            counter.count();
        }
        assertEquals(10, counter.getCount());

        counter.changeDir();

        for (int i = 0; i < 5; i++) {
            counter.count();
        }
        
        assertEquals(5, counter.getCount());

        counter.changeDir();
        for (int i = 0; i < 3; i++) {
            counter.count();
        }
        assertEquals(8, counter.getCount());
    }

}
