package com.example.ooprojectblocks.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TroubleMakerGenerator {
    private int width;

    public TroubleMakerGenerator(int width) {
        this.width = width;
    }

    public void generate(List<Object> objects) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            temp.add(i);
        }
        Collections.shuffle(temp);
        if(temp.get(0) == 0)
            objects.add(new TroubleMaker(width / 10 - width / 40, 0, width / 20, width / 20, null));
        else if(temp.get(0) == 1)
            objects.add(new TroubleMaker(width / 10 * 3 - width / 40, 0, width / 20, width / 20, null));
        else if(temp.get(0) == 2)
            objects.add(new TroubleMaker(width / 10 * 5 - width / 40, 0, width / 20, width / 20, null));
        else if(temp.get(0) == 3)
            objects.add(new TroubleMaker(width / 10 * 7 - width / 40, 0, width / 20, width / 20, null));
        else if(temp.get(0) == 4)
            objects.add(new TroubleMaker(width / 10 * 9 - width / 40, 0, width / 20, width / 20, null));
    }
}
