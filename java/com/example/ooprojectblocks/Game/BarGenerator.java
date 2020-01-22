package com.example.ooprojectblocks.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BarGenerator {

    private int width;

    public BarGenerator(int width) {
        this.width = width;
    }

    public void generate(List<Object> objects) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        if(temp.get(0) == 0)
            objects.add(new Bar(0, 0, width, width / 10, "blue"));
        else if(temp.get(0) == 1)
            objects.add(new Bar(0, 0, width, width / 10, "brown"));
        else if(temp.get(0) == 2)
            objects.add(new Bar(0, 0, width, width / 10, "green"));
        else if(temp.get(0) == 3)
            objects.add(new Bar(0, 0, width, width / 10, "red"));
        else if(temp.get(0) == 4)
            objects.add(new Bar(0, 0, width, width / 10, "yellow"));
    }
}
