package lab3.view;

import java.awt.*;
import javax.swing.*;
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
    String style = "<html> <style> h1 {font-size: 25px; color: green; font-weight: bold; border: 4px solid black;} div {display: flex; padding: 10px; justify-content: center; text-align: center; align-items: center; width: 100%; padding-left: 20px}</style> <div> <h1>";

    DefaultListModel<String> listan;
    JList<String> listan2;
    JScrollPane listanscroll;

    JPanel actions = new JPanel();
    JScrollPane scrollPane;

    JComboBox<String> dag = new JComboBox<String>();
    JComboBox<Integer> tim = new JComboBox<Integer>();
    JComboBox<Integer> min = new JComboBox<Integer>();
    JComboBox<Integer> sek = new JComboBox<Integer>();

    String[] dagar = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    public AlarmsAndButtons(AlarmController alarmc) {
        con = alarmc;
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);

        listan = new DefaultListModel<>(); // Det man kan klicka på
        listan2 = new JList<>(listan); // En lista på de man kan klicka pp
        listanscroll = new JScrollPane(listan2); // Den vissar listan

        
        creatButtons();
        add(listanscroll, BorderLayout.CENTER);
    }

    private void creatButtons() {
        
        // butonspanel.setPreferredSize(getPreferredSize());

        con.görDetta(() -> {
            this.repaint();
            this.revalidate();
            if (con.checkIfAlarm())
            new AlarmDialog();
        });

        add.addActionListener(e -> {
            TimeType tid = new Time(dag.getSelectedIndex(), tim.getSelectedIndex(), min.getSelectedIndex(), sek.getSelectedIndex());

            if (con.getAlarm(tid) == null) {
                con.addAlarm(tid);
                
                String b = tid.toString() + con.toString(new Alarm(tid));

                listan.addElement(style  + b);
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

        butonspanel.add(add);
        butonspanel.add(remove);
        butonspanel.add(set);
        butonspanel.add(creatOptions(), BorderLayout.EAST);

        this.add(butonspanel, BorderLayout.NORTH);
    }

    private JPanel creatOptions() {
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