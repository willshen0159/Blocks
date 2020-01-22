package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.ooprojectblocks.R;

import java.util.List;
import java.util.Random;

public class ContactDetector {
    private SoundPool soundPool;
    Activity activity;
    boolean sound;

    int bar, randombar, touch, troublemaker, goldensnitch;

    public ContactDetector(boolean sound, Activity activity) {
        this.activity = activity;
        this.sound = sound;
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);
        bar = soundPool.load(activity, R.raw.bar, 1);
        randombar = soundPool.load(activity, R.raw.randombar, 1);
        touch = soundPool.load(activity, R.raw.touch, 1);
        troublemaker = soundPool.load(activity, R.raw.troublemaker, 1);
        goldensnitch = soundPool.load(activity, R.raw.goldensnitch, 1);
    }


    public void detectFor1player(List<Object> objects, Hero hero) {
        if(!sound) {
            for (Object o : objects) {
                if (isTouch(o, hero))
                    o.contact(objects, o, hero);
            }
        }
        else {
            for (Object o : objects) {
                if (isTouch(o, hero)) {
                    o.contact(objects, o, hero);
                    playSound(o);
                }
            }
        }
    }
    public void detectFor2player(List<Object> objects, Hero player1, Hero player2) {
        if(!sound) {
            for (Object o : objects) {
                if (isTouch(o, player1) && isTouch(o, player2)) {
                    if (o.getType().equals("randomBar") || o.getType().equals("block")) {
                        o.contact(objects, o, player1);
                        o.contact(objects, o, player2);
                    } else {
                        int temp = new Random().nextInt(2);
                        if (temp == 1)
                            o.contact(objects, o, player1);
                        else
                            o.contact(objects, o, player2);
                    }
                }
                else if (isTouch(o, player1)) {
                    o.contact(objects, o, player1);
                }
                else if (isTouch(o, player2)) {
                    o.contact(objects, o, player2);
                }
            }
        }
        else {
            for (Object o : objects) {
                if (isTouch(o, player1) && isTouch(o, player2)) {
                    if (o.getType().equals("randomBar") || o.getType().equals("block")) {
                        o.contact(objects, o, player1);
                        o.contact(objects, o, player2);
                    } else {
                        int temp = new Random().nextInt(2);
                        if (temp == 1)
                            o.contact(objects, o, player1);
                        else
                            o.contact(objects, o, player2);
                    }
                    playSound(o);
                }
                else if (isTouch(o, player1)) {
                    o.contact(objects, o, player1);
                    playSound(o);
                }
                else if (isTouch(o, player2)) {
                    o.contact(objects, o, player2);
                    playSound(o);
                }
            }
        }
    }

    public boolean isTouch(Object o, Hero hero) {
        return (o.getX() <= hero.getX() + hero.getWidth() && o.getX() + o.getWidth() >= hero.getX() &&
                o.getY() <= hero.getY() + hero.getHeight() && o.getY() + o.getHeight() >= hero.getY());
    }

    public void playSound(Object o) {
        if(o.getType().equals("block"))
            soundPool.play(touch, 1.0F, 1.0F, 0, 0, 1.0F);
        else if(o.getType().equals("bar"))
            soundPool.play(bar, 1.0F, 1.0F, 0, 0, 1.0F);
        else if(o.getType().equals("randomBar"))
            soundPool.play(randombar, 1.0F, 1.0F, 0, 0, 1.0F);
        else if(o.getType().equals("troubleMaker"))
            soundPool.play(troublemaker, 1.0F, 1.0F, 0, 0, 1.0F);
        else if(o.getType().equals("goldenSnitch"))
            soundPool.play(goldensnitch, 1.0F, 1.0F, 0, 0, 1.0F);
    }
}
