package lab3.counter;

public interface CounterType {
    void count();              
    int getCount();
    void reset();
    void pause();
    void resume();
    String toString();
}