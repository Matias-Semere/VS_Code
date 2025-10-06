package lab3.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class AlarmDialog extends JDialog {

    float opacity;
    
    public AlarmDialog() {
        setTitle("Alarm!");  
        setModal(false);
        
        setUndecorated(true);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.RED);

        JLabel label = new JLabel("Alarm!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setForeground(Color.BLACK);
        panel.add(label, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.BLACK);
        closeButton.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(closeButton, BorderLayout.SOUTH);

        add(panel);

        setSize(300, 150);
        setLocationRelativeTo(null);
        // setOpacity(0f);

        setShape(new RoundRectangle2D.Double(0, 0, 300, 150, 50, 50));
        setVisible(true);

        List<Runnable> effects = new ArrayList<>();

        // opacity = 0f;
        int amplitude = 20;
        Point originalLocation = this.getLocation();

        // effects.add(() -> {
        //     opacity += 0.05f;
        //     if (opacity > 1f)
        //     opacity = 0.05f;
        //     this.setOpacity(opacity);
        // });

        effects.add(() -> {
            int xOffset = (int) (Math.random() * amplitude - amplitude / 2);
            // int yOffset = (int) (Math.random() * amplitude - amplitude / 2);
            int yOffset = 0;
            this.setLocation(originalLocation.x + xOffset, originalLocation.y + yOffset);
        });


        Timer animation = new Timer(30, e -> effects.forEach(s -> s.run()));
        animation.start();
    }

}
