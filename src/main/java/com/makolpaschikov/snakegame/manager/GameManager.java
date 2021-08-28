package com.makolpaschikov.snakegame.manager;

import com.makolpaschikov.snakegame.entity.apple.AppleList;
import com.makolpaschikov.snakegame.entity.score.Score;
import com.makolpaschikov.snakegame.entity.snake.Snake;
import com.makolpaschikov.snakegame.movement.Direction;
import com.makolpaschikov.snakegame.movement.MovementController;
import com.makolpaschikov.snakegame.movement.TriggersChecker;
import com.makolpaschikov.snakegame.screen.GameScreen;

public class GameManager implements GameManagerUI {

    private Snake snake;
    private Score score;
    private AppleList apples;
    private final GameScreen gameScreen;

    public GameManager() {
        score = new Score();
        snake = new Snake();
        apples = new AppleList(snake);
        gameScreen = new GameScreen(score, apples, snake);
    }

    @Override
    public void start() {
        runGameCycle();      // Started game cycle
        waitUserReadiness(); // After the end of the game, it expects the user to start the game again
        refreshGameData();   // Resets the game to the initial settings
        start();             // Starts the game again
    }

    private void runGameCycle() {
        while (RuntimeParameters.gameIsRunning) {
            gameScreen.draw(score, apples, snake);

            TriggersChecker.checkEatingApple(score, snake, apples);
            TriggersChecker.checkScore(score, snake, apples);
            if (!TriggersChecker.checkSnakeIsAlive(snake)) {
                RuntimeParameters.gameIsRunning = false;
                break;
            }

            MovementController.updateDirection();
            MovementController.moveSnake(snake);

            try {
                Thread.sleep(RuntimeParameters.gameSpeed);
            } catch (InterruptedException e) {
                // The exception is ignored, since the current thread is not affected by other threads
            }
        }

        gameScreen.draw(score, apples, snake);
    }

    private void waitUserReadiness() {
        RuntimeParameters.gamerNotReadyToRestart = true;
        while (RuntimeParameters.gamerNotReadyToRestart) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // The exception is ignored, since the current thread is not affected by other threads
            }
        }
    }

    private void refreshGameData() {
        score = new Score();
        snake = new Snake();
        apples = new AppleList(snake);

        RuntimeParameters.gameSpeed = 500;
        RuntimeParameters.gameIsRunning = true;
        MovementController.setDirection(Direction.LEFT);
    }

}
