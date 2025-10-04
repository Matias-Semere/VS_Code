package lab3.view;

import java.awt.*;
import java.util.stream.IntStream;

import javax.swing.*;

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

        
        listan = new DefaultListModel<>();
        listan2 = new JList<>(listan);
        listanscroll = new JScrollPane(listan2);

        

        creatOptions();
        creatButtons();

        add(listanscroll, BorderLayout.CENTER);
    }

    public void creatButtons() {
        listanscroll.setPreferredSize(new Dimension(400, 200));

        con.görDetta(() -> {
            this.repaint();
            this.revalidate();
        });

        add.addActionListener(e -> {
            TimeType tid = new Time(dag.getSelectedIndex(), tim.getSelectedIndex(), min.getSelectedIndex(), sek.getSelectedIndex());
            if(con.getAlarm(tid) == null){
                con.addAlarm(tid);
                listan.addElement(tid.toString());
            }
        });
        
        remove.addActionListener(e -> {
            if (listan.getSize() > 0) {
                TimeType tid = new Time(listan2.getSelectedValue());
                con.removeAlarm(tid);
                listan.removeElement(listan2.getSelectedValue());
            }
        });

        set.addActionListener(e -> {
            TimeType tid = new Time(listan2.getSelectedValue());
            con.setActive(new Alarm(tid), true);               
            listan.setElementAt(tid.toString(), listan2.getSelectedIndex());
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
}