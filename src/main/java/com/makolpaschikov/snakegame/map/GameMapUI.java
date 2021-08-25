package com.makolpaschikov.snakegame.map;

import com.makolpaschikov.snakegame.score.Score;
import com.makolpaschikov.snakegame.snake.Snake;

public interface GameMapUI {

    void resetMap();

    void printMap(Score score, Snake snake);

}
