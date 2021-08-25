package com.makolpaschikov.snakegame.manager;

import com.makolpaschikov.snakegame.manager.questioner.UserQuestioner;
import com.makolpaschikov.snakegame.map.GameMap;
import com.makolpaschikov.snakegame.score.Score;
import com.makolpaschikov.snakegame.snake.Snake;

public class GameManager implements GameManagerUI {

    private final Snake SNAKE;
    private final Score SCORE;
    private final GameMap GAME_MAP;

    public GameManager() {
        SNAKE = new Snake();
        SCORE = new Score();
        GAME_MAP = new GameMap();
    }

    @Override
    public void start() {
        UserQuestioner.askUserAboutReadiness();
        GAME_MAP.resetMap();
        GAME_MAP.printMap(SCORE, SNAKE);
    }

}
