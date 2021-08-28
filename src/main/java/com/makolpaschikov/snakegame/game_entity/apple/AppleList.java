package com.makolpaschikov.snakegame.game_entity.apple;

import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.ArrayList;
import java.util.List;

public class AppleList {

    private final List<Apple> apples;

    public AppleList(Snake snake) {
        this.apples = new ArrayList<>();
        this.apples.add(generateApple(snake));
    }

    public List<Apple> getApples() {
        return apples;
    }

    public void generateNewApple(Snake snake) {
        this.apples.add(generateApple(snake));
    }

    private Apple generateApple(Snake snake) {
        int x = generateCoordinateX();
        int y = generateCoordinateY();
        Apple apple = new Apple(x, y);

        for (var a : apples) {
            if (a.equals(apple)) {
                apple = generateApple(snake);
                break;
            }
        }

        if (snake.getHead().getX() == apple.getX() && snake.getHead().getY() == apple.getY()) {
            apple = generateApple(snake);
        }

        for (var s : snake.getTail()) {
            if (s.getX() == apple.getX() && s.getY() == apple.getY()) {
                apple = generateApple(snake);
                break;
            }
        }

        return apple;
    }

    private int generateCoordinateX() {
        int x = ((int) (Math.random() * CanvasParameters.WIDTH));
        int remains = x % 10;
        return (x - remains);
    }

    private int generateCoordinateY() {
        int y = ((int) (Math.random() * CanvasParameters.HEIGHT));
        int remains = y % 10;
        return (y - remains);
    }

}
