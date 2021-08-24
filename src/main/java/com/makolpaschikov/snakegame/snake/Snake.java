package com.makolpaschikov.snakegame.snake;

import com.makolpaschikov.snakegame.map.MapParameters;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final List<SnakePoint> SNAKE_TAIL = new ArrayList<>();

    public Snake() {
        SNAKE_TAIL.add(new SnakePoint(MapParameters.WIDTH / 2, MapParameters.HEIGHT / 2));
        SNAKE_TAIL.add(new SnakePoint(MapParameters.WIDTH / 2, MapParameters.HEIGHT / 2 + 1));
        SNAKE_TAIL.add(new SnakePoint(MapParameters.WIDTH / 2, MapParameters.HEIGHT / 2 + 2));
    }

    public List<SnakePoint> getTail() {
        return this.SNAKE_TAIL;
    }
}
