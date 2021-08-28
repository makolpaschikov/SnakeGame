package com.makolpaschikov.snakegame.manager;

import com.makolpaschikov.snakegame.game_entity.apple.AppleList;
import com.makolpaschikov.snakegame.game_entity.score.Score;
import com.makolpaschikov.snakegame.game_entity.snake.Snake;
import com.makolpaschikov.snakegame.manager.move_controller.MoveController;
import com.makolpaschikov.snakegame.screen.GameScreen;

public class GameManager implements GameManagerUI {

    private final Snake snake;
    private final Score score;
    private final AppleList apples;
    private final GameScreen gameScreen;

    public GameManager() {
        score = new Score();
        snake = new Snake();
        apples = new AppleList(snake);
        gameScreen = new GameScreen(score, apples, snake);
    }

    @Override
    public void start() {
        startGameCycle();
    }

    private void startGameCycle(){
        while (RuntimeParameters.gameIsRunning) {
            gameScreen.updateMap(score, apples, snake);

            if (!MoveController.сheckSnakeCoordinates(snake)) {
                return;
            }

            MoveController.moveSnake(snake);

            try {
                Thread.sleep(RuntimeParameters.gameSpeed);
            } catch (InterruptedException e) {
                // The exception is ignored, since the current thread is not affected by other threads
            }
        }
    }

}
