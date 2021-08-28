package com.makolpaschikov.snakegame.manager.move_controller;

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

    @Override
    public void keyReleased(KeyEvent e) {
        setDirection(e.getKeyCode());
    }

    static private void setDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                MoveController.addMoveToQueue(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                MoveController.addMoveToQueue(Direction.RIGTH);
                break;
            case KeyEvent.VK_W:
                MoveController.addMoveToQueue(Direction.UP);
                break;
            case KeyEvent.VK_S:
                MoveController.addMoveToQueue(Direction.DOWN);
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
