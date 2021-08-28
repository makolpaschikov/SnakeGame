package com.makolpaschikov.snakegame.manager.move_controller;

import com.makolpaschikov.snakegame.game_entity.score.snake.SnakePoint;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.List;

public class MoveController {

    static private Direction direction = Direction.DOWN;

    static public void moveSnake(Snake snake) {
        SnakePoint snakeHead = snake.getHead();
        SnakePoint headCoordinates = new SnakePoint(snakeHead.getX(), snakeHead.getY());

        updateHeadCoordinates(snake.getHead());
        updateTailCoordinates(snake.getTail(), headCoordinates);
    }

    public static void setDirection(Direction direction) {
        MoveController.direction = direction;
    }

    static private void updateHeadCoordinates(SnakePoint snakeHead) {
        switch (direction) {
            case UP: {
                int yCoordinate = snakeHead.getY();
                snakeHead.setY(yCoordinate - CanvasParameters.SNAKE_SIZE);
                break;
            }
            case DOWN: {
                int yCoordinate = snakeHead.getY();
                snakeHead.setY(yCoordinate + CanvasParameters.SNAKE_SIZE);
                break;
            }
            case LEFT: {
                int xCoordinate = snakeHead.getX();
                snakeHead.setX(xCoordinate - CanvasParameters.SNAKE_SIZE);
                break;
            }
            case RIGTH: {
                int xCoordinate = snakeHead.getX();
                snakeHead.setX(xCoordinate + CanvasParameters.SNAKE_SIZE);
                break;
            }
        }
    }

    static private void updateTailCoordinates(List<SnakePoint> snakeTail, SnakePoint headCoordinates) {
        snakeTail.forEach(t -> {
            SnakePoint temp = new SnakePoint(t.getX(), t.getY());

            t.setX(headCoordinates.getX());
            t.setY(headCoordinates.getY());

            headCoordinates.setX(temp.getX());
            headCoordinates.setY(temp.getY());
        });
    }

}
