package com.makolpaschikov.snakegame.movement;

import com.makolpaschikov.snakegame.entity.apple.AppleList;
import com.makolpaschikov.snakegame.entity.score.Score;
import com.makolpaschikov.snakegame.entity.snake.Snake;
import com.makolpaschikov.snakegame.entity.snake.SnakePoint;
import com.makolpaschikov.snakegame.manager.RuntimeParameters;
import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.List;

public class TriggersChecker {

    /**
     * Checks if the snake has not eaten its tail.
     */
    static public boolean checkSnakeIsAlive(Snake snake) {
        SnakePoint head = snake.getHead();
        List<SnakePoint> tail = snake.getTail();
        for (SnakePoint t : tail) {
            if (t.equals(head)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the score and, depending on its value, changes the speed of the game and the number of apples on the map.
     */
    static public void checkScore(Score score, Snake snake, AppleList apples) {
        if (score.getScore() >= 100 && score.getScore() < 200) {
            if (apples.getApples().size() != 2) {
                apples.generateNewApple(snake);
            }
            RuntimeParameters.gameSpeed = 400;
            return;
        }

        if (score.getScore() >= 200 && score.getScore() < 300) {
            if (apples.getApples().size() != 3) {
                apples.generateNewApple(snake);
            }
            RuntimeParameters.gameSpeed = 325;
            return;
        }

        if (score.getScore() >= 300 && score.getScore() < 400) {
            if (apples.getApples().size() != 4) {
                apples.generateNewApple(snake);
            }
            RuntimeParameters.gameSpeed = 260;
            return;
        }

        if (score.getScore() >= 400) {
            if (apples.getApples().size() != 5) {
                apples.generateNewApple(snake);
            }
            RuntimeParameters.gameSpeed = 200;
        }

    }

    /**
     * Checks if the snake has not eaten an apple.
     */
    static public void checkEatingApple(Score score, Snake snake, AppleList apples) {
        SnakePoint head = snake.getHead();

        for (var a : apples.getApples()) {
            if (a.getX() == head.getX() && a.getY() == head.getY()) {
                addNewSnakePoint(snake);
                score.increaseScore();
                apples.getApples().remove(a);
                apples.generateNewApple(snake);
                break;
            }
        }
    }

    static private void addNewSnakePoint(Snake snake) {
        List<SnakePoint> tail = snake.getTail();

        SnakePoint newPoint;
        SnakePoint lastTailPoint = tail.get(tail.size() - 1);
        switch (MovementController.getDirection()) {
            case UP:
                newPoint = new SnakePoint(lastTailPoint.getX(), lastTailPoint.getY() + CanvasParameters.SNAKE_SIZE);
                break;
            case DOWN:
                newPoint = new SnakePoint(lastTailPoint.getX(), lastTailPoint.getY() - CanvasParameters.SNAKE_SIZE);
                break;
            case LEFT:
                newPoint = new SnakePoint(lastTailPoint.getX() + CanvasParameters.SNAKE_SIZE, lastTailPoint.getY());
                break;
            case RIGTH:
                newPoint = new SnakePoint(lastTailPoint.getX() - CanvasParameters.SNAKE_SIZE, lastTailPoint.getY());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + MovementController.getDirection());
        }
        tail.add(newPoint);
    }
}
