package lab3.view;

import javax.swing.*;
import java.awt.*;
import lab3.controller.ClockController;


public class ClockAndButtons extends JPanel{

    ClockController con;

    public ClockAndButtons(ClockController alarmc) {
        con = alarmc;
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(400, 200));
        add(new JLabel("Detta är clock and buttons"));
        JLabel label = new JLabel(con.toString());
        add(label);
    } 

}
