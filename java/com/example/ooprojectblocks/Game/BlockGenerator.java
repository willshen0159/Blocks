package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockGenerator {

    private int width;

    public BlockGenerator(int width) {
        this.width = width;
    }

    public void generate(List<Object> objects) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        for(int i = 0; i < 5; i++) {
            if(temp.get(i) == 0)
                objects.add(new Block(i * (width / 5), 0, width / 5, width / 5, "blue"));
            else if(temp.get(i) == 1)
                objects.add(new Block(i * (width / 5), 0, width / 5, width / 5, "brown"));
            else if(temp.get(i) == 2)
                objects.add(new Block(i * (width / 5), 0, width / 5, width / 5, "green"));
            else if(temp.get(i) == 3)
                objects.add(new Block(i * (width / 5), 0, width / 5, width / 5, "red"));
            else if(temp.get(i) == 4)
                objects.add(new Block(i * (width / 5), 0, width / 5, width / 5, "yellow"));
        }
    }
}
