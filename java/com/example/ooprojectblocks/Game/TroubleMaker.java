package com.example.ooprojectblocks.Game;

public class TroubleMaker extends Object {
    public TroubleMaker(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("troubleMaker");
        setContactBehavior(new RandomAllColor());
    }
}
