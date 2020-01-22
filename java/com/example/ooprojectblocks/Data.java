package com.example.ooprojectblocks;

public class Data {
    public String id;
    public String mode;
    public String player1;
    public String player2;

    public boolean bgm;
    public boolean sound;
    public boolean colorBlind;

    public Data() {
        this.id = null;
        this.mode = null;
        this.player1 = "square";
        this.player2 = "square";
        this.bgm = true;
        this.sound = true;
        this.colorBlind = false;
    }
}
