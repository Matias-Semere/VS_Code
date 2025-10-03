package lab3.view;

import java.awt.*;
import javax.swing.*;
import lab3.controller.AlarmController;

public class AlarmsAndButtons extends JPanel {

    MainFrame parrent;
    AlarmController con;

    JLabel alarm = new JLabel();
    JButton add = new JButton("Add");
    JButton remove = new JButton("Remove");
    JButton removeAll = new JButton("Remove All");
    JButton set = new JButton("Set Aktive / Inaktive");
    // JScrollPane listan = new JScrollPane();
    JPanel listan = new JPanel();

    public AlarmsAndButtons(AlarmController alarmc) {
        con = alarmc;
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(400, 200));
        creatButtons();
    }

    void creatButtons() {
        
        add.addActionListener(e -> {
            // TimeType tid = new Time(0,0,10,0);
            // con.addAlarm(tid);
            // listan.add(new JLabel(con.getAlarm(tid)));
            listan.add(new JLabel("Detta är en alarm"));
            
        });


        remove.addActionListener(e -> {
            // TimeType tid = new Time(0,0,10,0);
            // con.removeAlarm(tid);
            // listan.add(new JLabel(con.getAlarm(tid)));
            listan.remove(new JLabel("Detta är en alarm"));
        });

        this.add(add);
        this.add(remove);
        this.add(listan);

    
    }

}