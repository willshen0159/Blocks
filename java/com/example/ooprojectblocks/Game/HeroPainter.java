package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ooprojectblocks.R;

public abstract class HeroPainter {

    protected Activity activity;
    protected ConstraintLayout layout;
    protected boolean colorBlind;

    public HeroPainter(Activity activity, ConstraintLayout layout, boolean colorBlind) {
        this.activity = activity;
        this.layout = layout;
        this.colorBlind = colorBlind;
    }

    public abstract void paint(Hero hero);
}
