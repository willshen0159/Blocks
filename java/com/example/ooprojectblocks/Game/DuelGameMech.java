package com.example.ooprojectblocks.Game;

import android.app.Activity;
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
import java.util.Random;

public class DuelGameMech extends GameMech {

    BlockGenerator blockGenerator;
    RandomBarGenerator randomBarGenerator;
    GoldenSnitchGenerator goldenSnitchGenerator;
    TroubleMakerGenerator troubleMakerGenerator;
    LinkedList<Object> objects;
    Hero player1;
    boolean player1moveleft;
    boolean player1moveright;
    Hero player2;
    boolean player2moveleft;
    boolean player2moveright;
    ContactDetector detector;
    ScreenScroller screenScroller;
    ObjectPainter objectPainter;
    HeroPainter heroPainter1;
    HeroPainter heroPainter2;
    Cleaner cleaner;

    ConstraintLayout layout;
    Activity activity;

    Button left1Button;
    Button right1Button;
    Button left2Button;
    Button right2Button;
    TextView text;

    int speed;
    int width;
    int height;
    int time;
    Random random;

    public DuelGameMech(String player1, String player2, boolean bgm, boolean sound, boolean colorBlind, ConstraintLayout layout, Activity activity) {
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
        if (player2.equals("square"))
            this.heroPainter2 = new SquareHeroPainter(activity, layout, colorBlind);
        else if(player2.equals("circle"))
            this.heroPainter2 = new CircleHeroPainter(activity, layout, colorBlind);
        else if (player2.equals("triangle"))
            this.heroPainter2 = new TriangleHeroPainter(activity, layout, colorBlind);
        score = 0;
        screenScroller.setSpeed(10);
        time = 0;
        speed = 10;
        random = new Random();
        text = (TextView) layout.findViewById(R.id.score);
        left1Button = (Button) layout.findViewById(R.id.left1Button);
        right1Button = (Button) layout.findViewById(R.id.right1Button);
        left2Button = (Button) layout.findViewById(R.id.left2Button);
        right2Button = (Button) layout.findViewById(R.id.right2Button);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        blockGenerator = new BlockGenerator(width);
        randomBarGenerator = new RandomBarGenerator(width);
        goldenSnitchGenerator = new GoldenSnitchGenerator(width);
        troubleMakerGenerator = new TroubleMakerGenerator(width);
        this.player1 = new Hero(width / 10 * 3 - width / 40, height - (width / 3), width / 20, width / 20, "red");
        this.player2 = new Hero(width / 10 * 7 - width / 40, height - (width / 3), width / 20, width / 20, "blue");
        cleaner = new Cleaner(height, layout);
        player1moveleft = false;
        player1moveright = false;
        player2moveleft = false;
        player2moveright = false;
    }

    public int run() {
        setTouch();
        if (time % 60 == 0)
            score++;
        if (time % 400 == 0) {
            int temp = random.nextInt(2);
            if (temp == 0)
                goldenSnitchGenerator.generate(objects);
            else
                troubleMakerGenerator.generate(objects);
        }
        if (time % 70 == 0) {
            if (time % 350 == 0)
                randomBarGenerator.generate(objects);
            else
                blockGenerator.generate(objects);
        }
        heroPainter1.paint(player1);
        heroPainter2.paint(player2);
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
        if(player2moveleft) {
            if(player2.getX() < 0);
            else
                player2.setX(player2.getX() - 20);
        }
        if(player2moveright) {
            if(player2.getX() + player2.getWidth() > width);
            else
                player2.setX(player2.getX() + 20);
        }
        screenScroller.scroll(objects);
        detector.detectFor2player(objects, player1, player2);
        cleaner.clean(objects);
        time++;
        if (player1.getState() == -1 && player2.getState() == -1) {
            unsetTouch();
            text.setText("Draw");
            text.setAlpha((float)1.0);
            text.bringToFront();
            return 0;
        }
        else if(player1.getState() == -1) {
            unsetTouch();
            text.setText("P2 Win");
            text.setAlpha((float)1.0);
            text.bringToFront();
            return 0;
        }
        else if(player2.getState() == -1) {
            unsetTouch();
            text.setText("P1 Win");
            text.setAlpha((float)1.0);
            text.bringToFront();
            return 0;
        }
        return 1;
    }

    public void pause() {
        unsetTouch();
    }

    public void setTouch() {
        left1Button.setOnTouchListener(new View.OnTouchListener() {
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
        right1Button.setOnTouchListener(new View.OnTouchListener() {
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
        left2Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                    player2moveleft = true;
                }
                else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    player2moveleft = false;
                }
                return true;
            }
        });
        right2Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                    player2moveright = true;
                }
                else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    player2moveright = false;
                }
                return true;
            }
        });
    }

    /*public void setTouch() {
        left1Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player1.getX() < 0)
                    return false;
                else
                    player1.setX(player1.getX() - 20);
                return false;
            }
        });
        right1Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player1.getX() + player1.getWidth() > width)
                    return false;
                else
                    player1.setX(player1.getX() + 20);
                return false;
            }
        });
        left2Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player2.getX() < 0)
                    return false;
                else
                    player2.setX(player2.getX() - 20);
                return false;
            }
        });
        right2Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(player2.getX() + player2.getWidth() > width)
                    return false;
                else
                    player2.setX(player2.getX() + 20);
                return false;
            }
        });
    }*/

    public void unsetTouch() {
        left1Button.setOnTouchListener(null);
        right1Button.setOnTouchListener(null);
        left2Button.setOnTouchListener(null);
        right2Button.setOnTouchListener(null);
    }
}
