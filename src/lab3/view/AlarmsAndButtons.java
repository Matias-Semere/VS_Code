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
    JPanel actions = new JPanel();

    DefaultListModel<String> listan;
    JList<String> listan2;
    JScrollPane listanscroll;

    String style = "<html><style> h1 {font-size: 25px; color: green; font-weight: bold; border: 4px solid black;} div {display: flex; padding: 10px; justify-content: center; text-align: center; align-items: center; width: 100%; padding-left: 50px}</style> <div> <h1>";
    String[] dagar = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
    JComboBox<String> dag = new JComboBox<String>(dagar);
    JComboBox<Integer> tim, min, sek;

    public AlarmsAndButtons(AlarmController alarmc) {
        con = alarmc;
        setPreferredSize(new Dimension(550, 100));
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);

        listan = new DefaultListModel<>(); // Det man kan klicka på
        listan2 = new JList<>(listan); // En lista på de man kan klicka pp
        listanscroll = new JScrollPane(listan2); // Den vissar listan

        actions.setLayout(new FlowLayout());

        creatButtons();
        listanscroll.setBackground(Color.ORANGE);
        listanscroll.setForeground(Color.BLACK);
        add(listanscroll);
    }

    private void creatButtons() {

        con.görDetta(() -> {
            this.repaint();
            this.revalidate();
            if (con.checkIfAlarm())
                new AlarmDialog();
        });

        add.addActionListener(e -> {
            TimeType tid = new Time(dag.getSelectedIndex(), tim.getSelectedIndex(), min.getSelectedIndex(),
                    sek.getSelectedIndex());

            if (con.getAlarm(tid) == null) {
                con.addAlarm(tid);

                String b = tid.toString() + con.toString(new Alarm(tid));

                listan.addElement(style + b + "</h1>");
            }
        });

        remove.addActionListener(e -> {
            if (listan.getSize() > 0) {
                String temp = listan2.getSelectedValue();
                String[] str = temp.substring(temp.indexOf("<h1>") + 4, temp.indexOf("</h1>")).split(" ");
                TimeType tid = new Time(str[0] + " " + str[1]);
                con.removeAlarm(tid);
                listan.removeElementAt(listan2.getSelectedIndex());
            }
        });

        set.addActionListener(e -> {
            String temp = listan2.getSelectedValue();
            String[] str = temp.substring(temp.indexOf("<h1>") + 4, temp.indexOf("</h1>")).split(" ");
            TimeType tid = new Time(str[0] + " " + str[1]);
            if (str[2].equals("Aktiv"))
                con.setActive(tid, false);
            else
                con.setActive(tid, true);
            String ändrasTill = tid.toString() + con.toString(con.getAlarm(tid));
            listan.setElementAt(style + ändrasTill + "</h1>", listan2.getSelectedIndex());
        });

        butonspanel.add(add);
        butonspanel.add(remove);
        butonspanel.add(set);

        actions.add(butonspanel, BorderLayout.WEST);
        actions.add(creatOptions(), BorderLayout.EAST);
        
        this.add(actions, BorderLayout.NORTH);
    }

    private JPanel creatOptions() {
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
        return combopanel;
    }
}