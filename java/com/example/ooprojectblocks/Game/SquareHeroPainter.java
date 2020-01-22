package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ooprojectblocks.R;

public class SquareHeroPainter extends HeroPainter {

    public SquareHeroPainter(Activity activity, ConstraintLayout layout, boolean colorBlind) {
        super(activity, layout, colorBlind);
    }

    public void paint(Hero hero) {
        if (!colorBlind) {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blueblock);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.brownblock);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greenblock);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redblock);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowblock);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blueblock);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.brownblock);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greenblock);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redblock);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowblock);
                }
            }
        }
        else {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindblueblock);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrownblock);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreenblock);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredblock);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowblock);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindblueblock);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrownblock);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreenblock);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredblock);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowblock);
                }
            }
        }
    }

}
