package com.makolpaschikov.snakegame.screen.canvas;

import com.makolpaschikov.snakegame.game_entity.score.snake.SnakePoint;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JComponent {

    private Snake snake;

    public Canvas(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        clearCanvas(graphics);
        paintBackground(graphics);
        paintSnake(graphics);
    }

    @Override
    public void repaint() {
        paintComponent(getGraphics());
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    private void clearCanvas(Graphics2D graphics) {
        graphics.clearRect(5, 5, CanvasParameters.WIDTH, CanvasParameters.HEIGHT);
    }

    private void paintBackground(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(5, 5, CanvasParameters.WIDTH, CanvasParameters.HEIGHT);
    }

    private void paintSnake(Graphics2D graphics) {
        paintSnakeHead(graphics);
        paintSnakeTail(graphics);
    }

    private void paintSnakeHead(Graphics2D graphics) {
        SnakePoint head = this.snake.getHead();
        graphics.setColor(CanvasParameters.SNAKE_HEAD_COLOR);
        graphics.fillRect(head.getX(), head.getY(), CanvasParameters.SNAKE_SIZE, CanvasParameters.SNAKE_SIZE);
    }

    private void paintSnakeTail(Graphics2D graphics) {
        List<SnakePoint> tail = this.snake.getTail();
        graphics.setColor(CanvasParameters.SNAKE_TAIL_COLOR);
        tail.forEach(t -> graphics.fillRect(t.getX(), t.getY(), CanvasParameters.SNAKE_SIZE, CanvasParameters.SNAKE_SIZE));
    }

}
