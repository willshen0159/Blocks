package com.example.ooprojectblocks.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomAllColor extends ContactBehavior {
    public void perform(List<Object> objects, Object o, Hero hero) {
        for (Object obj: objects) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                temp.add(i);
            }
            Collections.shuffle(temp);
            if (temp.get(0) == 0)
                obj.setColor("red");
            else if (temp.get(0) == 1)
                obj.setColor("blue");
            else if (temp.get(0) == 2)
                obj.setColor("green");
            else if (temp.get(0) == 3)
                obj.setColor("yellow");
            else if (temp.get(0) == 4)
                obj.setColor("brown");
        }
    }
}
