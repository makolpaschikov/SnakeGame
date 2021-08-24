package com.makolpaschikov.snakegame;

import com.makolpaschikov.snakegame.manager.GameManager;

public class Application {

    static private final GameManager GAME_MANAGER = new GameManager();

    public static void main(String[] args) {
       GAME_MANAGER.start();
    }
}
