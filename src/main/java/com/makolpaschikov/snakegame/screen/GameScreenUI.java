package com.makolpaschikov.snakegame.screen;

import com.makolpaschikov.snakegame.entity.apple.AppleList;
import com.makolpaschikov.snakegame.entity.score.Score;
import com.makolpaschikov.snakegame.entity.snake.Snake;

public interface GameScreenUI {

    void draw(Score score, AppleList apples, Snake snake);

}
