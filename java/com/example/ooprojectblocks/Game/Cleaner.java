package com.example.ooprojectblocks.Game;

import android.support.constraint.ConstraintLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Cleaner {

    private int height;
    private ConstraintLayout layout;

    public Cleaner(int height, ConstraintLayout layout) {
        this.height = height;
        this.layout = layout;
    }

    public void clean(List<Object> objects) {
        for (Object o: new ArrayList<Object>(objects)) {
            if(o.getY() > height || o.getState() == -1) {
                layout.removeView(o.image);
                objects.remove(o);
            }
        }
    }
}
