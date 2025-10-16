package main;

import javax.swing.*;

/**
 * Used for the main game window
 */

public class GameWindow {
    private JFrame window;

    // Set the main game window properties
    public GameWindow(JPanel mainPanel) {
        window = new JFrame("Inheritors Rift");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(mainPanel);
        window.setVisible(true);
    }

    public JFrame getFrame() {
        return window;
    }
}