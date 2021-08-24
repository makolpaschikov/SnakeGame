package com.makolpaschikov.snakegame.map;

import com.makolpaschikov.snakegame.snake.Snake;
import com.makolpaschikov.snakegame.snake.SnakePoint;

import java.util.List;

public class GameMap implements GameMapUI {

    private final String[][] GAME_MAP = new String[MapParameters.HEIGHT][MapParameters.WIDTH];

    @Override
    public void resetMap() {
        for (int row = 0; row < MapParameters.HEIGHT; row++) {
            for (int col = 0; col < MapParameters.WIDTH; col++) {
                GAME_MAP[row][col] = "";
            }
        }
    }

    @Override
    public void printMap(Snake snake) {
        List<SnakePoint> tail = snake.getTail();
        tail.forEach(t -> GAME_MAP[t.Y][t.X] = "O");

        for (int row = 0; row < MapParameters.HEIGHT; row++) {
            for (int col = 0; col < MapParameters.WIDTH; col++) {
                if (!GAME_MAP[row][col].equals("O")) {
                    System.out.print("•");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

}


