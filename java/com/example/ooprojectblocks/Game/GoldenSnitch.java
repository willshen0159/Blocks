package com.example.ooprojectblocks.Game;

public class GoldenSnitch extends Object {
    public GoldenSnitch(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("goldenSnitch");
        setContactBehavior(new ChangeAllColor());
    }
}
