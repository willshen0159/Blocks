package com.example.ooprojectblocks.Game;

import java.util.List;

public class TouchDie extends ContactBehavior {
    public void perform(List<Object> objects, Object o, Hero hero) {
        if(!o.getColor().equals(hero.getColor()))
            hero.setState(-1);
    }
}
