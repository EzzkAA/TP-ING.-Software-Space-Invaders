package com.zetcode.UI.View;

import com.zetcode.UI.Model.Commons;
import com.zetcode.UI.Controller.GameController;
import com.zetcode.UI.Controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private JButton startButton;
    private JButton exitButton;
    private JFrame parentFrame;
    private Image backgroundImage;
    private MenuController menuController;

    public MainMenu(JFrame frame, GameController gameController) {
        this.parentFrame = frame;
        this.menuController = new MenuController(this,gameController);
        setLayout(null);
        loadBackgroundImage();
        initializeButtons();
    }

    private void loadBackgroundImage() {
        var ii = new ImageIcon("src/resources/images/menu1.png");
        backgroundImage = ii.getImage();
    }

    private void initializeButtons() {
        // Botón de Iniciar
        startButton = new JButton("Iniciar Juego");
        startButton.setBounds(Commons.BOARD_WIDTH/2 - 100, Commons.BOARD_HEIGHT/2 - 50, 200, 40);
        startButton.setBackground(new Color(60, 144, 83));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> menuController.startNewGame());

        // Botón de Salir
        exitButton = new JButton("Salir");
        exitButton.setBounds(Commons.BOARD_WIDTH/2 - 100, Commons.BOARD_HEIGHT/2 + 10, 200, 40);
        exitButton.setBackground(new Color(144, 60, 60));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> menuController.exitGame());

        add(startButton);
        add(exitButton);
    }

    public void showGameBoard(Board gameBoard){
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(gameBoard);
        parentFrame.revalidate();
        parentFrame.repaint();
        gameBoard.requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Dibujar título
        //g.setColor(Color.WHITE);
        //Font titleFont = new Font("Arial", Font.BOLD, 40);
        //g.setFont(titleFont);
        //String title = "Space Invaders";
        //FontMetrics metrics = g.getFontMetrics(titleFont);
        //int titleX = (Commons.BOARD_WIDTH - metrics.stringWidth(title)) / 2;
        //g.drawString(title, titleX, Commons.BOARD_HEIGHT/3);
    }
}