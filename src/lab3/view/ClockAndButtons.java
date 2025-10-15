package lab3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.stream.IntStream;

import lab3.controller.ClockController;

public class ClockAndButtons extends JPanel {

    JPanel butonspanel = new JPanel();
    JButton start, stop, reset, set;
    JComboBox<Integer> tim, min, sek;
    String[] dagar = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
    JComboBox<String> dag = new JComboBox<String>(dagar);

    public ClockAndButtons(ClockController con) {
        setLayout(new BorderLayout());
        creatButtons(con);

        Border emptyBorder = BorderFactory.createEmptyBorder(20, 40, 40, 40);

        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                new Color(255, 255, 255)),
                "Digital",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(255, 255, 255)
        );

        JLabel label = new JLabel(con.toString());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(30, 30, 30));

        label.setBorder(BorderFactory.createCompoundBorder(titledBorder, emptyBorder));

        con.SkickaVidare(() -> {
            label.setText(con.toString());
            label.repaint();
        });
        
        butonspanel.add(creatOptions());
        butonspanel.setBackground(new Color(20, 100, 180));

        JPanel alt = new JPanel();
        alt.setLayout(new BorderLayout());
        alt.setBackground(new Color(30, 30, 30));
        alt.add(butonspanel, BorderLayout.NORTH);
        alt.add(label, BorderLayout.SOUTH);

        add(alt, BorderLayout.NORTH);
        JPanel analogclock = new AnalogClock(con);

        titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(
                new Color(255, 255, 255)),
                "Analog",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(255, 255, 255)
        );

        analogclock.setBorder(BorderFactory.createCompoundBorder(titledBorder, emptyBorder));

        add(analogclock, BorderLayout.CENTER);
    }

    private JPanel creatOptions() {
        JPanel combopanel = new JPanel();
        tim = new JComboBox<Integer>();
        min = new JComboBox<Integer>();
        sek = new JComboBox<Integer>();
        IntStream.range(0, 24).forEach(i -> tim.addItem(i));
        IntStream.range(0, 60).forEach(i -> min.addItem(i));
        IntStream.range(0, 60).forEach(i -> sek.addItem(i));
        combopanel.add(dag);
        combopanel.add(tim);
        combopanel.add(min);
        combopanel.add(sek);
        combopanel.setBackground(new Color(20, 100, 180));
        return combopanel;
    }

    private void creatButtons(ClockController con) {
        start = new JButton("Start");
        stop = new JButton("Stop");
        reset = new JButton("Reset");
        set = new JButton(" Set Time");

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

        butonspanel.setPreferredSize(new Dimension(400, 52));
        butonspanel.add(styler(start));
        butonspanel.add(styler(stop));
        butonspanel.add(styler(reset));
        butonspanel.add(styler(set));
    }

    private JButton styler(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBorderPainted(true);

        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding
        button.setOpaque(true);
        return button;
    }
}