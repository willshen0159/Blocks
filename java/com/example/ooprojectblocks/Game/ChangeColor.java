package com.example.ooprojectblocks.Game;

import java.util.List;

public class ChangeColor extends ContactBehavior {
    public void perform(List<Object> objects, Object o, Hero hero) {
        hero.setColor(o.getColor());
    }
}
