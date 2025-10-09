package lab3.view;

import java.awt.*;
import javax.swing.*;
import lab3.controller.ClockController;
import lab3.time.TimeType;

public class AnalogClock extends JPanel {

    int w, h, size, cx, cy, r, x, y;

    BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    ClockController clockc;

    public AnalogClock(ClockController controller) {
        this.clockc = controller;

        // setBorder(BorderFactory.createEmptyBorder(10, 10, 20,10));
        setBackground(new Color(30, 30, 30));
        setPreferredSize(new Dimension(400, 400));
         
    }

    private void init() {
        w = getWidth();
        h = getHeight();
        size = Math.min(w, h) - 40;
        cx = w / 2;
        cy = h / 2;
        r = size / 2;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Always call this first!
        Graphics2D ritare = (Graphics2D) g;
        init();

        ritare.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ritare.setStroke(stroke);
        ritare.setColor(Color.WHITE);

        ritare.drawOval(cx - r, cy - r, size, size);
        ritare.fillOval(cx - 5, cy - 5, 10, 10);
        TimeType t = clockc.getTime();
        
        ritaText(ritare, r);
        ritaSträck(ritare, r);

        ritaVisare(ritare, r - 80, t.getHour(), 1);
        ritare.setColor(Color.green);
        ritaVisare(ritare, r - 60, t.getMinute(), 0);
        ritare.setColor(Color.red);
        ritaVisare(ritare, r - 40, t.getSecond(), 0);

        clockc.SkickaVidare(() -> {
            revalidate();
            repaint();
        });

    }

    public void ritaVisare(Graphics2D ritare, int längden, int a, int b) {
        int grader = (b == 0) ? 6 : 30;

        x = (int) (cx + längden * Math.cos(Math.toRadians((a * grader) - 90)));
        y = (int) (cy + längden * Math.sin(Math.toRadians((a * grader) - 90)));

        ritare.drawLine(cx, cy, x + 5, y);
    }

    public void ritaText(Graphics2D ritare, int r) {
        ritare.setColor(Color.WHITE);
        ritare.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        r -= 30;
        for (int i = 30; i <= 360; i += 30) {
            x = (int) (cx - 7 + r * Math.cos(Math.toRadians((i) - 90)));
            y = (int) (cy + 7 + r * Math.sin(Math.toRadians((i) - 90)));
            ritare.drawString(String.valueOf(i / 30), x, y);
        }
    }

    public void ritaSträck(Graphics2D ritare, int r) {
        ritare.setColor(Color.WHITE);
        for (int i = 0; i <= 360; i += 6) {
            int len = (i % 30 == 0) ? 15 : 7;
            x = (int) (cx + r * Math.cos(Math.toRadians((i) - 90)));
            y = (int) (cy + r * Math.sin(Math.toRadians((i) - 90)));

            int x2 = (int) (cx + (r-len) * Math.cos(Math.toRadians((i) - 90)));
            int y2 = (int) (cy + (r-len) * Math.sin(Math.toRadians((i) - 90)));

            ritare.drawLine(x, y, x2, y2);
        }
    }

}
