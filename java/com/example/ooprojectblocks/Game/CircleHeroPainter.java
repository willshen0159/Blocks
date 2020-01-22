package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ooprojectblocks.R;

public class CircleHeroPainter extends HeroPainter {

    public CircleHeroPainter(Activity activity, ConstraintLayout layout, boolean colorBlind) {
        super(activity, layout, colorBlind);
    }

    public void paint(Hero hero) {
        if(!colorBlind) {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.bluecircle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.browncircle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greencircle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redcircle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowcircle);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.bluecircle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.browncircle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greencircle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redcircle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowcircle);
                }
            }
        }
        else {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindbluecircle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrowncircle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreencircle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredcircle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowcircle);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindbluecircle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrowncircle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreencircle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredcircle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowcircle);
                }
            }
        }
    }
}
