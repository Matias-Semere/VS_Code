package lab3.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

import lab3.alarm.Alarm;
import lab3.controller.*;
import lab3.time.*;

public class AlarmsAndButtons extends JPanel {

    MainFrame parrent;
    AlarmController con;

    JLabel alarm = new JLabel();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JButton removeAll = new JButton("Remove All");
    JButton set = new JButton("Set Aktive / Inaktive");
    JPanel combopanel = new JPanel();
    JPanel butonspanel = new JPanel();
    float opacity;

    DefaultListModel<String> listan;
    JList<String> listan2;
    JScrollPane listanscroll;

    JComboBox<String> dag = new JComboBox<String>();
    JComboBox<Integer> tim = new JComboBox<Integer>();
    JComboBox<Integer> min = new JComboBox<Integer>();
    JComboBox<Integer> sek = new JComboBox<Integer>();

    String[] dagar = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    public AlarmsAndButtons(AlarmController alarmc) {
        con = alarmc;
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);
        setPreferredSize(new Dimension(400, 200));

        listan = new DefaultListModel<>(); // Det man kan klicka på
        listan2 = new JList<>(listan); // En lista på de man kan klicka pp
        listanscroll = new JScrollPane(listan2); // Den vissar listan

        creatOptions();
        creatButtons();

        add(listanscroll, BorderLayout.CENTER);
    }

    public void creatButtons() {
        listanscroll.setPreferredSize(new Dimension(400, 200));

        con.görDetta(() -> {
            this.repaint();
            this.revalidate();
            if (con.checkIfAlarm())
                alarm();
        });

        add.addActionListener(e -> {
            TimeType tid = new Time(dag.getSelectedIndex(), tim.getSelectedIndex(), min.getSelectedIndex(),
                    sek.getSelectedIndex());
            if (con.getAlarm(tid) == null) {
                con.addAlarm(tid);
                listan.addElement(tid.toString() + con.toString(new Alarm(tid)));
            }
        });

        remove.addActionListener(e -> {
            if (listan.getSize() > 0) {
                String[] str = listan2.getSelectedValue().split(" ");
                TimeType tid = new Time(str[0] + " " + str[1]);
                con.removeAlarm(tid);
                listan.removeElementAt(listan2.getSelectedIndex());
            }
        });

        set.addActionListener(e -> {
            String[] str = listan2.getSelectedValue().split(" ");
            TimeType tid = new Time(str[0] + " " + str[1]);
            if (str[2].equals("Aktiv"))
                con.setActive(tid, false);
            else
                con.setActive(tid, true);
            String ändrasTill = tid.toString() + con.toString(con.getAlarm(tid));
            listan.setElementAt(ändrasTill, listan2.getSelectedIndex());
        });

        butonspanel.add(set);
        butonspanel.add(add);
        butonspanel.add(remove);
        this.add(butonspanel, BorderLayout.SOUTH);
    }

    public void creatOptions() {
        IntStream.range(0, 7).forEach(i -> dag.addItem(dagar[i]));
        IntStream.range(0, 24).forEach(i -> tim.addItem(i));
        IntStream.range(0, 60).forEach(i -> min.addItem(i));
        IntStream.range(0, 60).forEach(i -> sek.addItem(i));
        combopanel.add(dag);
        combopanel.add(tim);
        combopanel.add(min);
        combopanel.add(sek);
        this.add(combopanel, BorderLayout.NORTH);
    }

    public void alarm() {
        JDialog dialog = new JDialog((Frame) null, "Animated Dialog", false);
        dialog.setUndecorated(true);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.RED);
        JLabel label = new JLabel("Alarm!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        panel.add(label, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        closeButton.setBackground(Color.RED);
        closeButton.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(closeButton, BorderLayout.SOUTH);

        dialog.add(panel);

        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setOpacity(0f);

        dialog.setShape(new RoundRectangle2D.Double(0, 0, 300, 150, 50, 50));
        dialog.setVisible(true);

        List<Runnable> effects = new ArrayList<>();

        opacity = 0f;
        int amplitude = 10;
        Point originalLocation = dialog.getLocation();

        effects.add(() -> {
            opacity += 0.05f;
            if (opacity > 1f)
                opacity = 0.05f;
            dialog.setOpacity(opacity);
        });

        effects.add(() -> {
            int xOffset = (int) (Math.random() * amplitude - amplitude / 2);
            int yOffset = (int) (Math.random() * amplitude - amplitude / 2);
            dialog.setLocation(originalLocation.x + xOffset, originalLocation.y + yOffset);
        });


        Timer animation = new Timer(30, e -> effects.forEach(s -> s.run()));
        animation.start();
    }
}