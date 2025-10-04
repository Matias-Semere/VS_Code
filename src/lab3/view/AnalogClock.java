package lab3.view;

import javax.swing.*;
import java.awt.*;

public class AnalogClock extends JPanel {

    public AnalogClock() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(400, 200));
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Always call this first!

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        
        int w = getWidth(), h = getHeight();
        int size = Math.min(w, h) - 20;
        int cx = w / 2, cy = h / 2;
        int r = size / 2;

        int b = 45;
        int a = (int) (Math.sin(Math.toRadians(b)) * r);
        
        g2d.setStroke(new BasicStroke(10));
        g2d.drawOval(cx - r, cy - r, size, size);
        g2d.fillOval(cx - 3, cy - 3, 10, 10);  
        
        
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);
        // g2d.drawLine(cx, cy, size-40, size-40);
        g2d.drawLine(cx, cy, a, a);
        b += 45;
        a = (int) (Math.sin(Math.toRadians(b)));
        g2d.drawLine(cx, cy, a, a);
        // g2d.drawLine(cx, cy, c, b);
        // g2d.drawLine(cx, cy, d, b);
        // g2d.drawLine(cx, cy, a, d);

        // g2d.setStroke(new BasicStroke(2));
        // g2d.drawLine(cx+2, 0, cx+2, h);
    }

    public void getloc() {

    }
}
