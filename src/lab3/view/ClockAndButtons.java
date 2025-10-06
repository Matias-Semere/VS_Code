package lab3.view;

import javax.swing.*;
import java.awt.*;
import lab3.controller.ClockController;
import lab3.time.*;


public class ClockAndButtons extends JPanel{

    ClockController con;

    public ClockAndButtons(ClockController alarmc) {
        con = alarmc;
        setBackground(Color.darkGray);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(400, 100));
        setLayout(new BorderLayout());

        JLabel label = new JLabel(con.toString());
        JButton settabel = new JButton(" Set Time");
        JPanel panel = new JPanel();

        settabel.addActionListener(e -> {
            // TimeType time = new Time(0, 0, 0, 0);
            con.setTime(0, 10, 20 ,30);
            label.setText(con.toString());
            label.repaint();
        });

        panel.add(settabel, BorderLayout.WEST);

        settabel.addActionListener(e -> {
            // TimeType time = new Time(0, 0, 0, 0);
            con.setTime(0, 20, 0 ,30);
            label.setText(con.toString());
            label.repaint();
        });

        panel.add(settabel, BorderLayout.EAST);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");
        
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setForeground(Color.white);

        con.SkickaVidare(() -> {
            label.setText(con.toString());
            label.repaint();
        });

        start.addActionListener(e -> {
            con.startClock();
        });
        
        stop.addActionListener(e -> {
            con.stopClock();
        });

        reset.addActionListener(e -> {
            con.resetClock();
        });

        // panel.add(start, BorderLayout.WEST);
        // panel.add(stop, BorderLayout.EAST);
        panel.add(reset, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    } 

}