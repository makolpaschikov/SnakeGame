package com.makolpaschikov.snakegame.screen.canvas;

import com.makolpaschikov.snakegame.game_entity.apple.AppleList;
import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.game_entity.score.snake.SnakePoint;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.screen.ScreenParameters;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JComponent {

    private Snake snake;
    private Score score;
    private AppleList apples;

    public Canvas(Score score, AppleList apples, Snake snake) {
        this.score = score;
        this.snake = snake;
        this.apples = apples;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        clearCanvas(graphics);
        paintScreenBackground(graphics);
        paintMapBackground(graphics);
        printScore(graphics);
        paintApples(graphics);
        paintSnake(graphics);
    }

    @Override
    public void repaint() {
        paintComponent(getGraphics());
    }

    public void setData(Score score, AppleList apples, Snake snake) {
        this.score = score;
        this.snake = snake;
        this.apples = apples;
    }

    private void clearCanvas(Graphics2D graphics) {
        graphics.clearRect(
                CanvasParameters.MAP_START_POS_X,
                CanvasParameters.MAP_START_POS_Y,
                CanvasParameters.WIDTH, CanvasParameters.HEIGHT
        );
    }

    private void paintScreenBackground(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, ScreenParameters.WIDTH, ScreenParameters.HEIGHT);
    }

    private void paintMapBackground(Graphics2D graphics) {
        graphics.setColor(CanvasParameters.MAP_BACKGROUND_COLOR);
        graphics.fillRect(
                CanvasParameters.MAP_START_POS_X,
                CanvasParameters.MAP_START_POS_Y,
                CanvasParameters.WIDTH, CanvasParameters.HEIGHT
        );
    }

    private void printScore(Graphics2D graphics) {
        graphics.setColor(CanvasParameters.SCORE_COLOR);
        graphics.drawString("Score: " + score.getScore(), CanvasParameters.SCORE_POS_X, CanvasParameters.SCORE_POS_Y);
    }

    private void paintApples(Graphics2D graphics) {
        graphics.setColor(Color.RED);
        apples.getApples().forEach(a ->
                graphics.fillRect(
                        a.getX() + CanvasParameters.MAP_START_POS_X,
                        a.getY() + CanvasParameters.MAP_START_POS_Y,
                        CanvasParameters.SNAKE_SIZE, CanvasParameters.SNAKE_SIZE
                )
        );
    }

    private void paintSnake(Graphics2D graphics) {
        paintSnakeHead(graphics);
        paintSnakeTail(graphics);
    }

    private void paintSnakeHead(Graphics2D graphics) {
        SnakePoint head = this.snake.getHead();
        graphics.setColor(CanvasParameters.SNAKE_HEAD_COLOR);
        graphics.fillRect(
                head.getX() + CanvasParameters.MAP_START_POS_X,
                head.getY() + CanvasParameters.MAP_START_POS_Y,
                CanvasParameters.SNAKE_SIZE, CanvasParameters.SNAKE_SIZE
        );
        drawBounds(graphics, head);
    }

    private void paintSnakeTail(Graphics2D graphics) {
        List<SnakePoint> tail = this.snake.getTail();
        tail.forEach(t -> {
            graphics.setColor(CanvasParameters.SNAKE_TAIL_COLOR);
            graphics.fillRect(
                    t.getX() + CanvasParameters.MAP_START_POS_X,
                    t.getY() + CanvasParameters.MAP_START_POS_Y,
                    CanvasParameters.SNAKE_SIZE, CanvasParameters.SNAKE_SIZE
            );
            drawBounds(graphics, t);
        });
    }

    private void drawBounds(Graphics2D graphics, SnakePoint snakePoint) {
        graphics.setColor(Color.GRAY);

        // Top
        graphics.drawLine(
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y,
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X + CanvasParameters.SNAKE_SIZE,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y
        );

        // Left
        graphics.drawLine(
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y,
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y + CanvasParameters.SNAKE_SIZE
        );

        // Bottom
        graphics.drawLine(
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y + CanvasParameters.SNAKE_SIZE,
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X + CanvasParameters.SNAKE_SIZE,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y + CanvasParameters.SNAKE_SIZE
        );

        // Right
        graphics.drawLine(
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X + CanvasParameters.SNAKE_SIZE,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y,
                snakePoint.getX() + CanvasParameters.MAP_START_POS_X + CanvasParameters.SNAKE_SIZE,
                snakePoint.getY() + CanvasParameters.MAP_START_POS_Y + CanvasParameters.SNAKE_SIZE
        );
    }

}
