package com.makolpaschikov.snakegame.score;

public class Score implements ScoreUI {
    private int score = 0;

    @Override
    public void reset() {
        this.score = 0;
    }

    @Override
    public void printScore() {
        System.out.println("Score: " + score);
    }
}
