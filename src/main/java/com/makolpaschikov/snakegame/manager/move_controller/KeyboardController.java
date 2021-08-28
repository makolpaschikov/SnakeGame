package com.makolpaschikov.snakegame.manager.move_controller;

import com.makolpaschikov.snakegame.manager.RuntimeParameters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        setDirection(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        setDirection(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        setDirection(e.getKeyCode());
    }

    static private void setDirection(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_A:
                MoveController.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                MoveController.setDirection(Direction.RIGTH);
                break;
            case KeyEvent.VK_W:
                MoveController.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
                MoveController.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_ESCAPE:
                RuntimeParameters.gameIsRunning = false;
                break;
        }
    }
}
