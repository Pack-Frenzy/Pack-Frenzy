package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class LightenLoadItem extends BoxItem {

    private int effectSize; // multiplied to weight of box to reduce weight
                            // will range from .5 - .9


    public LightenLoadItem (int x, int y, Color colour) {
        super(x, y, colour);
        Random random = new Random();
        this.effectSize = (random.nextInt(50) + 51) / 100;
    }

    // NOTE: this constructor is to be used when effectSize is not to be
    //       randomly generated

    public LightenLoadItem (int x, int y, Color colour, int effectSize) {
        super (x, y, colour);
        this.effectSize = effectSize;
    }

    // EFFECTS: changes this.effectSize to given int

    public void changeEffectSize(int effectSize) {
        this.effectSize = effectSize;
    }

    public int getEffectSize() {
        return effectSize;
    }
}
