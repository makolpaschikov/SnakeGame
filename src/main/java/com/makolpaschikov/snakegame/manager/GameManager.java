package com.makolpaschikov.snakegame.manager;

import com.makolpaschikov.snakegame.manager.questioner.UserQuestioner;
import com.makolpaschikov.snakegame.map.GameMap;
import com.makolpaschikov.snakegame.snake.Snake;

public class GameManager implements GameManagerUI {

    private final GameMap GAME_MAP;

    private final Snake SNAKE;

    public GameManager() {
        SNAKE = new Snake();
        GAME_MAP = new GameMap();
    }

    @Override
    public void start() {
        UserQuestioner.askUserAboutReadiness();
        GAME_MAP.resetMap();
        GAME_MAP.printMap(SNAKE);
    }

}
