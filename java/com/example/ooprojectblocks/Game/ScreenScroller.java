package com.example.ooprojectblocks.Game;

import java.util.List;

public class ScreenScroller {

    int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void scroll(List<Object> objects) {
        for(Object o: objects) {
            if(o.getType().equals("goldenSnitch") || o.getType().equals("troubleMaker"))
                o.setY(o.getY() + 2 * speed);
            o.setY(o.getY() + speed);
        }
    }
}
