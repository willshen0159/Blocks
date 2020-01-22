package com.example.ooprojectblocks.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomChangeColor extends ContactBehavior {
    public void perform(List<Object> objects, Object o, Hero hero) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        if(temp.get(0) == 0)
            hero.setColor("red");
        else if(temp.get(0) == 1)
            hero.setColor("blue");
        else if(temp.get(0) == 2)
            hero.setColor("green");
        else if(temp.get(0) == 3)
            hero.setColor("yellow");
        else if(temp.get(0) == 4)
            hero.setColor("brown");
    }
}
