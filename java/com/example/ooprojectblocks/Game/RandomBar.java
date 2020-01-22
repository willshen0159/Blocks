package com.example.ooprojectblocks.Game;

public class RandomBar extends Object {
    public RandomBar(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("randomBar");
        setContactBehavior(new RandomChangeColor());
    }
}
