package com.makolpaschikov.snakegame.screen;

import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.manager.move_controller.KeyboardController;
import com.makolpaschikov.snakegame.screen.canvas.Canvas;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    private final Canvas canvas;

    public GameScreen(Score score, Snake snake) throws HeadlessException {
        super(ScreenParameters.GAME_TITLE);
        this.canvas = new Canvas(score, snake);
        createGUI();
    }

    private void createGUI() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(ScreenParameters.WIDTH, ScreenParameters.HEIGHT);
        super.setBackground(Color.BLACK);
        this.setScreenLocation();
        super.add(canvas);
        super.setResizable(false);
        super.setVisible(true);
        super.addKeyListener(new KeyboardController());
    }

    private void setScreenLocation() {
        Toolkit tools = Toolkit.getDefaultToolkit();
        Dimension screenSize = tools.getScreenSize();
        super.setLocation((screenSize.width / 2) - (ScreenParameters.WIDTH / 2),
                (screenSize.height / 2) - (ScreenParameters.HEIGHT / 2));
    }

    public void updateMap(Score score, Snake snake) {
        this.canvas.setData(score, snake);
        this.canvas.repaint();
    }

}


