package com.makolpaschikov.snakegame.screen;

import com.makolpaschikov.snakegame.game_entity.apple.AppleList;
import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;

public interface GameScreenUI {

    void draw(Score score, AppleList apples, Snake snake);

}
