package lab3.view;

import javax.swing.*;

import lab3.controller.ClockController;

import java.awt.*;

public class AnalogClock extends JPanel {

    int s = 30;
    int s2 = s + 60;
    int xs;
    int ys;
    int w;
    int h;
    ClockController clockc;

    public AnalogClock(ClockController controller) {
        this.clockc = controller;
        
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(400, 400));
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Always call this first!

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        
        w = getWidth();
        h = getHeight();
        int size = Math.min(w, h) - 20;
        int cx = w / 2, cy = h / 2;
        int r = size / 2;
        
        
        g2d.setStroke(new BasicStroke(10));
        g2d.drawOval(cx - r, cy - r, size, size);
        g2d.fillOval(cx - 3, cy - 3, 10, 10);  
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        
        clockc.SkickaVidare(() -> changeClock(g2d, cy, cx));
    }
    
    public void changeClock(Graphics2D g2d, int cy, int cx) {
        g2d.dispose();
        g2d.drawLine(cx+2, cy, xs , ys+25);
        s += 10;
        s2 += 10;
        xs = (int) (Math.sin(Math.toRadians(s)) * w);
        ys = (int) (Math.cos(Math.toRadians(s2)) * h);
        revalidate();
        repaint();
    }
}
