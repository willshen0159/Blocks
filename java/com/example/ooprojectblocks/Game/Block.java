package com.example.ooprojectblocks.Game;

public class Block extends Object {
    public Block(int x, int y, int w, int h, String c) {
        super(x, y, w, h, c);
        setType("block");
        setContactBehavior(new TouchDie());
    }
}
