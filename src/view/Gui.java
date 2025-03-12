package view;

import javax.swing.*;
import java.awt.*;

public class Gui 
{
    public Gui() {
        // Create the frame
        JFrame frame = new JFrame("Basic GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new GridBagLayout());

        // Create the panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        // Create buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Add buttons to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        // Add panel to the frame
        frame.add(panel, new GridBagConstraints());

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
