package com.makolpaschikov.snakegame.score;

public class Score implements ScoreUI {

    private int score = 0;

    @Override
    public void reset() {
        this.score = 0;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void increaseScore() {
        this.score = this.score + 10;
    }


}
