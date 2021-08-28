package com.makolpaschikov.snakegame.game_entity.snake;

import com.makolpaschikov.snakegame.screen.canvas.CanvasParameters;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final SnakePoint HEAD;
    private final List<SnakePoint> TAIL = new ArrayList<>();

    public Snake() {
        HEAD = new SnakePoint(CanvasParameters.WIDTH / 2, CanvasParameters.HEIGHT / 2);
        TAIL.add(new SnakePoint(CanvasParameters.WIDTH / 2 + CanvasParameters.SNAKE_SIZE, CanvasParameters.HEIGHT / 2));
        TAIL.add(new SnakePoint(CanvasParameters.WIDTH / 2 + CanvasParameters.SNAKE_SIZE * 2, CanvasParameters.HEIGHT / 2));
    }

    public SnakePoint getHead() {
        return this.HEAD;
    }

    public List<SnakePoint> getTail() {
        return this.TAIL;
    }

}
