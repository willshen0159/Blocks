package com.example.ooprojectblocks.Game;

public class Bar extends Object {
    public Bar(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("bar");
        setContactBehavior(new ChangeColor());
    }
}
