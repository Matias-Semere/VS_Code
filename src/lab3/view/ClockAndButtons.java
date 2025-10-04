package lab3.view;

import javax.swing.*;
import java.awt.*;
import lab3.controller.ClockController;


public class ClockAndButtons extends JPanel{

    ClockController con;

    public ClockAndButtons(ClockController alarmc) {
        con = alarmc;
        setBackground(Color.darkGray);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(400, 200));
        setLayout(new BorderLayout());

        JLabel label = new JLabel(con.toString());
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JPanel panel = new JPanel();
        
        label.setFont(new Font("Arial", Font.BOLD, 50));
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

        panel.add(start, BorderLayout.WEST);
        panel.add(stop, BorderLayout.EAST);        
        add(panel, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    } 

}