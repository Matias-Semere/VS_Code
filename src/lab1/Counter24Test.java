package lab1;

import static org.junit.Assert.*;
import org.junit.Test;

public class Counter24Test {

    @Test
    public void testCountIncreasing() {
    CounterType counter = new Counter24();
        for (int i = 0; i < 24; i++) {
            assertEquals(i, counter.getCount());
            counter.count();
        }
        assertEquals(0, counter.getCount());
        counter.count();
        assertEquals(1, counter.getCount());
    }

    @Test
    public void testChaining() {
        CounterType hours = new Counter24();
        CounterType minutes = new Counter60(hours);

        for (int i = 0; i < 60 * 2; i++) { // 2 hours
            minutes.count();
        }
        assertEquals(2, hours.getCount());
    }    

}