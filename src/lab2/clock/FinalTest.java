package lab2.clock;

public class FinalTest {

    public static void main(String[] args) {
        WeekAlarmClock test = new WeekAlarmClock();

        for (int i = 0; i <= 61; i++) {
            System.out.print("\r" + test.toString());
            test.tickTack();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
