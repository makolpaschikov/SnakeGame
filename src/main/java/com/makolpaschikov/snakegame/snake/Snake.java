package com.makolpaschikov.snakegame.snake;

import com.makolpaschikov.snakegame.map.MapParameters;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final SnakePoint HEAD;
    private final List<SnakePoint> TAIL = new ArrayList<>();

    public Snake() {
        HEAD = new SnakePoint(MapParameters.HEIGHT / 2, MapParameters.WIDTH / 2);
        TAIL.add(new SnakePoint(MapParameters.HEIGHT / 2 + 1, MapParameters.WIDTH / 2));
        TAIL.add(new SnakePoint(MapParameters.HEIGHT / 2 + 2, MapParameters.WIDTH / 2));
    }

    public SnakePoint getHead() {
        return this.HEAD;
    }

    public List<SnakePoint> getTail() {
        return this.TAIL;
    }
}
