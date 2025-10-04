package lab3.view;

import javax.swing.*;
import java.awt.*;
import lab3.controller.ClockController;


public class ClockAndButtons extends JPanel{

    ClockController con;

    public ClockAndButtons(ClockController alarmc) {
        con = alarmc;
        setBackground(Color.gray);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(400, 200));
        JLabel label = new JLabel(con.toString());
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        
        label.getFont().deriveFont(Font.BOLD, 50);
        label.setForeground(Color.white);

        con.görDetta(() -> {
            label.setText(con.toString());
            repaint();
            revalidate();
        });

        start.addActionListener(e -> {
            con.startClock();
        });
        
        stop.addActionListener(e -> {
            con.stopClock();
        });

        add(start);
        add(stop);        
        add(label);
    } 

}