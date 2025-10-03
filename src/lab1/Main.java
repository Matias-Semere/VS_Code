package lab1;

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();

        for (int i = 0; i <= 25; i++) {
            System.out.print("\r"+clock.getDayAndTime() + "  ");
            clock.addSec();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
