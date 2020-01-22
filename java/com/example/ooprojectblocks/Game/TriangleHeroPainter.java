package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

import com.example.ooprojectblocks.R;

public class TriangleHeroPainter extends HeroPainter {

    public TriangleHeroPainter(Activity activity, ConstraintLayout layout, boolean colorBlind) {
        super(activity, layout, colorBlind);
    }

    public void paint(Hero hero) {
        if(!colorBlind) {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.bluetriangle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.browntriangle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greentriangle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redtriangle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowtriangle);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.bluetriangle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.browntriangle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.greentriangle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.redtriangle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.yellowtriangle);
                }
            }
        }
        else {
            if (hero.getState() == 0) {
                hero.image = new ImageView(activity);
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindbluetriangle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrowntriangle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreentriangle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredtriangle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowtriangle);
                }
                ConstraintLayout.LayoutParams para = new ConstraintLayout.LayoutParams(hero.getWidth(), hero.getHeight());
                hero.image.setLayoutParams(para);
                hero.image.setX(hero.getX());
                hero.image.setY(hero.getY());
                layout.addView(hero.image);
                hero.setState(1);
            } else {
                if (hero.getColor().equals("blue")) {
                    hero.image.setImageResource(R.drawable.blindbluetriangle);
                } else if (hero.getColor().equals("brown")) {
                    hero.image.setImageResource(R.drawable.blindbrowntriangle);
                } else if (hero.getColor().equals("green")) {
                    hero.image.setImageResource(R.drawable.blindgreentriangle);
                } else if (hero.getColor().equals("red")) {
                    hero.image.setImageResource(R.drawable.blindredtriangle);
                } else if (hero.getColor().equals("yellow")) {
                    hero.image.setImageResource(R.drawable.blindyellowtriangle);
                }
            }
        }
    }
}
