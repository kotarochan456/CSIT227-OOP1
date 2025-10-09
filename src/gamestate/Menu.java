package gamestate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.GameHandler;

public class Menu extends JPanel{
    private GameHandler gameHandler;

    public Menu(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Inheritors Rift", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        startButton.setFocusPainted(false);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(200, 50));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameHandler.setGameState(GameState.PLAYING);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}