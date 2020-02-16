package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class LightenLoadItem extends BoxItem {

    private int effectSize; // multiplied to weight of box to reduce weight
                            // will range from .5 - .9


    public LightenLoadItem (int effectSize) {
        super ();
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
