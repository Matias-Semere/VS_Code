package lab1;

public interface CounterType {
    void count();              
    int getCount();
    void reset();
    void pause();
    void resume();
    void changeDir();
    String toString();
    // String getDay();
}