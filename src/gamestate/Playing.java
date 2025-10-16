package gamestate;

import javax.swing.*;
import java.awt.*;
import main.GameHandler;

public class Playing extends JPanel {
    private GameHandler gameHandler;
    private JPanel startPanel;
    private JLabel startLabel;

    public Playing(GameHandler gameHandler) {
        this.gameHandler = gameHandler;

        setLayout(null);
        setBackground(Color.BLACK);

        startPanel = new JPanel();
        startPanel.setBounds(300, 200, 200, 100);
        startPanel.setBackground(Color.BLACK);

        startLabel = new JLabel("Playing");
        startLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        startLabel.setForeground(Color.WHITE);

        startPanel.add(startLabel);
        add(startPanel);
    }
}