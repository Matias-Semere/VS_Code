package lab3.view;

import javax.swing.*;

import lab3.controller.ClockController;
import lab3.time.TimeType;

import java.awt.*;

public class AnalogClock extends JPanel {

    int w, h, size, cx, cy, r, x, y;

    BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND , BasicStroke.JOIN_ROUND);
    ClockController clockc;

    public AnalogClock(ClockController controller) {
        this.clockc = controller;
        
        setBackground(new Color(0, 20, 100));
        setPreferredSize(new Dimension(400, 400));
    }

    private void init() {
    w = getWidth();
    h = getHeight();
    size = Math.min(w, h) - 20;
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
        
        ritaVisare(ritare, r-80, t.getHour(), 1);
        ritare.setColor(Color.green);
        ritaVisare(ritare, r-60, t.getMinute(), 0);
        ritare.setColor(Color.red);
        ritaVisare(ritare, r-40, t.getSecond(), 0);
        ritaText(ritare, r);

        clockc.SkickaVidare(() -> {
            revalidate();
            repaint();
        });

    }
    
    public void ritaVisare(Graphics2D ritare, int längden, int a, int b) {
        int grader = (b == 0) ? 6 : 30;

        x = (int) (cx + längden * Math.cos(Math.toRadians((a*grader)-90)));
        y = (int) (cy + längden * Math.sin(Math.toRadians((a*grader)-90)));

        ritare.drawLine(cx, cy, x+5, y);
    }

    public void ritaText(Graphics2D ritare, int r) {
        ritare.setColor(Color.WHITE);
        ritare.setFont(new Font("Arial", Font.PLAIN, 20));
        r-=15;
        for (int i = 30; i <= 360; i+=30) {
            x = (int) (cx-5 + r * Math.cos(Math.toRadians((i)-90)));
            y = (int) (cy+7 + r * Math.sin(Math.toRadians((i)-90)));
            ritare.drawString(String.valueOf(i/30), x, y);
        }
    }

}

