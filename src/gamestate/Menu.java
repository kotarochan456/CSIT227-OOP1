package gamestate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.GameHandler;

public class Menu extends JPanel{
    private GameHandler gameHandler;
    private JPanel titleLabelPanel, startButtonPanel;
    private JLabel titleLabel;
    private JButton startButton;

    private int panelWidth;
    private int panelHeight;

    public Menu(GameHandler gameHandler) {
        this.gameHandler = gameHandler;

        panelWidth = 800;
        panelHeight = 600;

        setLayout(null);
        setBackground(Color.BLACK);

        titleLabelPanel = new JPanel();
        titleLabelPanel.setBounds(100, 100, 600, 100);
        titleLabelPanel.setBackground(Color.BLACK);

        titleLabel = new JLabel("Inheritors Rift");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 300, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);

        titleLabelPanel.add(titleLabel);
        startButtonPanel.add(startButton);
        add(titleLabelPanel);
        add(startButtonPanel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameHandler.setGameState(GameState.PLAYING);
            }
        });
    }
}