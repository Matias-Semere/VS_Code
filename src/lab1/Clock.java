package lab1;

public class Clock {

    // Counter7 dag = new Counter7();
    Counter24 hours = new Counter24();
    Counter60 minutes = new Counter60(hours);
    Counter60 seconds = new Counter60(minutes);

    public void addSec() {
        seconds.count();
    }
    
    public void addMin() {
        minutes.count();
    }

    public void addHour() {
        hours.count();
    }

    public String getDayAndTime() {
        // return dag.getDay() + " " + hours + ":" + minutes + ":" + seconds;
        return "Clockan är: " + hours + ":" + minutes + ":" + seconds;
    }

    public void resetAll() {
        hours.reset();
        minutes.reset();
        seconds.reset();
    }

    public void pauseAll() {
        hours.pause();
        minutes.pause();
        seconds.pause();
    }

    public void resumeAll() {
        hours.resume();
        minutes.resume();
        seconds.resume();
    }

    public void changeDirAll() {
        hours.changeDir();
        minutes.changeDir();
        seconds.changeDir();
    }

}
