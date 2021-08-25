package com.makolpaschikov.snakegame.map;

import com.makolpaschikov.snakegame.score.Score;
import com.makolpaschikov.snakegame.snake.Snake;
import com.makolpaschikov.snakegame.snake.SnakePoint;
import com.makolpaschikov.snakegame.util.ConsoleUtil;

import java.util.List;

public class GameMap implements GameMapUI {

    private final String[][] GAME_MAP = new String[MapParameters.HEIGHT][MapParameters.WIDTH];

    @Override
    public void resetMap() {
        for (int row = 0; row < MapParameters.HEIGHT; row++) {
            for (int col = 0; col < MapParameters.WIDTH; col++) {
                GAME_MAP[row][col] = "•";
            }
        }
    }

    @Override
    public void printMap(Score score, Snake snake) {
        printScore(score.getScore());

        SnakePoint head = snake.getHead();
        List<SnakePoint> tail = snake.getTail();
        GAME_MAP[head.X][head.Y] = "O";
        tail.forEach(t -> GAME_MAP[t.X][t.Y] = "o");

        for (int row = 0; row < MapParameters.HEIGHT; row++) {
            for (int col = 0; col < MapParameters.WIDTH; col++) {
                ConsoleUtil.print(GAME_MAP[row][col]);
            }
            ConsoleUtil.printEmptyLine();
        }
    }

    private void printScore(int score) {
        String scoreStr = Integer.toString(score);
        ConsoleUtil.println("Score: " + scoreStr);
        ConsoleUtil.printEmptyLine();
    }

}


