package com.makolpaschikov.snakegame.screen;

import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;

public interface GameScreenUI {

    void screenReset();

    void drawScreen(Score score, Snake snake);

}
