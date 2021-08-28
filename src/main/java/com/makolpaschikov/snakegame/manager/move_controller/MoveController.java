package com.makolpaschikov.snakegame.manager.move_controller;

import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.game_entity.snake.SnakePoint;
import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MoveController {

    static private Direction direction = Direction.LEFT;
    static private final Queue<Direction> moveQueue = new LinkedList<>();

    static public void moveSnake(Snake snake) {
        SnakePoint snakeHead = snake.getHead();
        SnakePoint headCoordinates = new SnakePoint(snakeHead.getX(), snakeHead.getY());

        updateHeadCoordinates(snake.getHead());
        updateTailCoordinates(snake.getTail(), headCoordinates);
    }

    static public void addMoveToQueue(Direction direction) {
        moveQueue.add(direction);
    }

    static public void updateDirection() {
        if (moveQueue.size() != 0) {
            MoveController.direction = moveQueue.poll();
        }
    }

    static private void updateHeadCoordinates(SnakePoint snakeHead) {
        switch (direction) {
            case UP: {
                int yCoordinate = snakeHead.getY();
                if (yCoordinate == 0) {
                    yCoordinate = CanvasParameters.HEIGHT;
                }
                snakeHead.setY(yCoordinate - CanvasParameters.SNAKE_SIZE);
                break;
            }
            case DOWN: {
                int yCoordinate = snakeHead.getY();
                if (yCoordinate == (CanvasParameters.HEIGHT - CanvasParameters.SNAKE_SIZE)) {
                    yCoordinate = -CanvasParameters.SNAKE_SIZE;
                }
                snakeHead.setY(yCoordinate + CanvasParameters.SNAKE_SIZE);
                break;
            }
            case LEFT: {
                int xCoordinate = snakeHead.getX();
                if (xCoordinate == 0) {
                    xCoordinate = CanvasParameters.WIDTH;
                }
                snakeHead.setX(xCoordinate - CanvasParameters.SNAKE_SIZE);
                break;
            }
            case RIGTH: {
                int xCoordinate = snakeHead.getX();
                if (xCoordinate == CanvasParameters.WIDTH - CanvasParameters.SNAKE_SIZE) {
                    xCoordinate = -CanvasParameters.SNAKE_SIZE;
                }
                snakeHead.setX(xCoordinate + CanvasParameters.SNAKE_SIZE);
                break;
            }
        }
    }

    public static Direction getDirection() {
        return direction;
    }

    public static void setDirection(Direction direction) {
        MoveController.direction = direction;
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
