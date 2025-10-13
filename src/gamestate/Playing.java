package gamestate;

import javax.swing.*;
import java.awt.*;
import main.GameHandler;



public class Playing extends JPanel {
    private GameHandler gameHandler;

    public Playing(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        setBackground(Color.BLACK);

        JLabel label = new JLabel("Game Started! You are now in the Rift.", SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);

        add(label);
    }
}