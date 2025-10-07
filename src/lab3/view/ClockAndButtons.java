package lab3.view;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

import lab3.controller.ClockController;


public class ClockAndButtons extends JPanel {

    ClockController con;
    JPanel combopanel = new JPanel();
    JPanel butonspanel = new JPanel();
    JComboBox<String> dag = new JComboBox<String>();
    JComboBox<Integer> tim, min, sek;
    String[] dagar = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    public ClockAndButtons(ClockController alarmc) {
        con = alarmc;
        setBackground(Color.darkGray);
        setForeground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel(con.toString());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton reset = new JButton("Reset");
        JButton set = new JButton(" Set Time");
        
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
        
        set.addActionListener(e -> {
            con.setTime(dag.getSelectedIndex(), tim.getSelectedIndex(), min.getSelectedIndex(), sek.getSelectedIndex());
        });

        butonspanel.setLayout(new FlowLayout());
        butonspanel.add(start);
        butonspanel.add(stop);
        butonspanel.add(reset);
        butonspanel.add(set);
        butonspanel.add(creatOptions(), BorderLayout.EAST);
        add(butonspanel, BorderLayout.SOUTH);
        add(label, BorderLayout.CENTER);
    } 

    private JPanel creatOptions() {
        combopanel.setLayout(new FlowLayout());
        tim = new JComboBox<Integer>();
        min = new JComboBox<Integer>();
        sek = new JComboBox<Integer>();
        IntStream.range(0, 7).forEach(i -> dag.addItem(dagar[i]));
        IntStream.range(0, 24).forEach(i -> tim.addItem(i));
        IntStream.range(0, 60).forEach(i -> min.addItem(i));
        IntStream.range(0, 60).forEach(i -> sek.addItem(i));
        combopanel.add(dag);
        combopanel.add(tim);
        combopanel.add(min);
        combopanel.add(sek);
        return combopanel;
    }

}