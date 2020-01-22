package com.example.ooprojectblocks.Game;

public class Hero extends Object {
    public Hero(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("hero");
        setContactBehavior(new None());
    }
}
