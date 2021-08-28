package com.makolpaschikov.snakegame.movement;

import com.makolpaschikov.snakegame.manager.RuntimeParameters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Adds a direction to the traffic queue {@link MovementController#addMovementToQueue(Direction)}.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        setDirection(e.getKeyCode());
    }

    static private void setDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                MovementController.addMovementToQueue(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                MovementController.addMovementToQueue(Direction.RIGTH);
                break;
            case KeyEvent.VK_W:
                MovementController.addMovementToQueue(Direction.UP);
                break;
            case KeyEvent.VK_S:
                MovementController.addMovementToQueue(Direction.DOWN);
                break;
            case KeyEvent.VK_ESCAPE:
                RuntimeParameters.gameIsRunning = false;
                break;
            case KeyEvent.VK_ENTER:
                RuntimeParameters.gamerNotReadyToRestart = false;
                break;
        }
    }
}
