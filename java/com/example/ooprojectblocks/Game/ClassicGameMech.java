package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ooprojectblocks.R;

import java.util.LinkedList;

public class ClassicGameMech extends GameMech {

    BlockGenerator blockGenerator;
    BarGenerator barGenerator;
    LinkedList<Object> objects;
    Hero player1;
    boolean player1moveleft;
    boolean player1moveright;
    ContactDetector detector;
    ScreenScroller screenScroller;
    ObjectPainter objectPainter;
    HeroPainter heroPainter1;
    Cleaner cleaner;

    ConstraintLayout layout;
    Activity activity;

    Button leftButton;
    Button rightButton;
    TextView scoreTextView;

    boolean sound;
    SoundPool soundPool;
    int die;

    int speed;
    int width;
    int height;
    int time;

    public ClassicGameMech(String player1, String player2, boolean bgm, boolean sound, boolean colorBlind, ConstraintLayout layout, Activity activity) {
        this.sound = sound;
        detector = new ContactDetector(sound, activity);
        screenScroller = new ScreenScroller();
        objects = new LinkedList<Object>();
        this.layout = layout;
        this.activity = activity;
        objectPainter = new ObjectPainter(activity, layout, colorBlind);
        if (player1.equals("square"))
            this.heroPainter1 = new SquareHeroPainter(activity, layout, colorBlind);
        else if (player1.equals("circle"))
            this.heroPainter1 = new CircleHeroPainter(activity, layout, colorBlind);
        else if (player1.equals("triangle"))
            this.heroPainter1 = new TriangleHeroPainter(activity, layout, colorBlind);
        score = 0;
        screenScroller.setSpeed(10);
        time = 0;
        speed = 10;
        scoreTextView = (TextView) layout.findViewById(R.id.score);
        leftButton = (Button) layout.findViewById(R.id.leftButton);
        rightButton = (Button) layout.findViewById(R.id.rightButton);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        blockGenerator = new BlockGenerator(width);
        barGenerator = new BarGenerator(width);
        this.player1 = new Hero(width / 2 - width / 40, height - (width / 3), width / 20, height / 20, "red");
        cleaner = new Cleaner(height, layout);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        die = soundPool.load(activity, R.raw.die, 1);
        player1moveleft = false;
        player1moveright = false;
    }

    public int run() {
        setTouch();
        scoreTextView.setAlpha((float)0.4);
        if (time % 60 == 0)
            score++;
        if (time % 70 == 0) {
            if (time % 350 == 0)
                barGenerator.generate(objects);
            else
                blockGenerator.generate(objects);
        }
        heroPainter1.paint(player1);
        objectPainter.paint(objects);
        if(player1moveleft) {
            if(player1.getX() < 0);
            else
                player1.setX(player1.getX() - 20);
        }
        if(player1moveright) {
            if(player1.getX() + player1.getWidth() > width);
            else
                player1.setX(player1.getX() + 20);
        }
        screenScroller.scroll(objects);
        detector.detectFor1player(objects, player1);
        cleaner.clean(objects);
        time++;
        scoreTextView.setText("" + score);
        if (player1.getState() == -1) {
            if(sound)
                soundPool.play(die, 1.0F, 1.0F, 0, 0, 1.0F);
            unsetTouch();
            scoreTextView.setAlpha((float)1.0);
            scoreTextView.bringToFront();
            return 0;
        }
        return 1;
    }

    public void pause() {
        unsetTouch();
        scoreTextView.setAlpha((float)1.0);
        scoreTextView.bringToFront();
    }

    public void setTouch() {
        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                    player1moveleft = true;
                }
                else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    player1moveleft = false;
                }
                return true;
            }
        });
        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                    player1moveright = true;
                }
                else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    player1moveright = false;
                }
                return true;
            }
        });
    }

    /*public void setTouch() {
        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player1.getX() < 0)
                    return false;
                else
                    player1.setX(player1.getX() - 20);
                return false;
            }
        });
        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player1.getX() + player1.getWidth() > width)
                    return false;
                else
                    player1.setX(player1.getX() + 20);
                return false;
            }
        });
    }*/

    public void unsetTouch() {
        leftButton.setOnTouchListener(null);
        rightButton.setOnTouchListener(null);
    }
}
