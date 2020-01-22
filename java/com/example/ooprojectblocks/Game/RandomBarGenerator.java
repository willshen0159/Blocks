package com.example.ooprojectblocks.Game;

import java.util.List;

public class RandomBarGenerator {
    private int width;

    public RandomBarGenerator(int width) {
        this.width = width;
    }

    public void generate(List<Object> objects) {
        objects.add(new RandomBar(0, 0, width, width / 10, null));
    }
}
