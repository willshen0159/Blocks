package com.example.ooprojectblocks.Game;

import java.util.List;

public class ChangeAllColor extends ContactBehavior {
    public void perform(List<Object> objects, Object o, Hero hero) {
        for(Object objs: objects)
            objs.setColor(hero.getColor());
    }
}
