package main;

import javax.swing.*;
import gamestate.*;
import gamestate.Menu;

/**
 * Manages switching between game screens
 */

public class GameHandler {
    private GameWindow gameWindow;
    private JPanel currentPanel;

    // Game state tracker
    private GameState gameState = GameState.MENU;
    private Menu menu;
    private Playing playing;

    public GameHandler() {
        menu = new Menu(this);
        playing = new Playing(this);

        gameWindow = new GameWindow(menu);
        currentPanel = menu;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;

        // Swap the displayed panel
        JFrame frame = gameWindow.getFrame();
        frame.getContentPane().removeAll();

        switch (gameState) {
            case MENU -> currentPanel = menu;
            case PLAYING -> currentPanel = playing;
        }

        frame.add(currentPanel);
        frame.revalidate();
        frame.repaint();
    }
}