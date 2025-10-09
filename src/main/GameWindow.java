package main;

import javax.swing.*;

/**
 * Used for the main game window
 */

public class GameWindow {
    private JFrame jFrame;

    // Set the main game window properties
    public GameWindow(JPanel startPanel) {
        jFrame = new JFrame("Inheritors Rift");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 500);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(startPanel);
        jFrame.setVisible(true);
    }

    public JFrame getFrame() {
        return jFrame;
    }
}