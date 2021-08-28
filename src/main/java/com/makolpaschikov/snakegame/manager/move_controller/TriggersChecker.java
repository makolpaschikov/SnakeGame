package com.makolpaschikov.snakegame.manager.move_controller;

import com.makolpaschikov.snakegame.game_entity.apple.AppleList;
import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.game_entity.snake.SnakePoint;
import com.makolpaschikov.snakegame.manager.RuntimeParameters;
import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.List;

public class TriggersChecker {

    static public boolean checkSnakeCoordinates(Snake snake) {
        SnakePoint head = snake.getHead();
        List<SnakePoint> tail = snake.getTail();
        for (SnakePoint t : tail) {
            if (t.equals(head)) {
                return false;
            }
        }
        return true;
    }

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
        switch (MoveController.getDirection()) {
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
                throw new IllegalStateException("Unexpected value: " + MoveController.getDirection());
        }
        tail.add(newPoint);
    }
}
