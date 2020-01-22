package com.example.ooprojectblocks.Game;

public abstract class GameMech {

    protected int score;

    public int getScore() {
        return score;
    }

    public abstract int run();
    public abstract void pause();
}
