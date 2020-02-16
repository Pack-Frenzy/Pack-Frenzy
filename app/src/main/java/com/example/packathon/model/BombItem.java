package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class BombItem extends BoxItem {
    private int radiusOfEffect;

    public BombItem() {
        super();
        Random random = new Random();
        this.radiusOfEffect = random.nextInt(3) + 1;
    }

    // NOTE: this constructor is to be used when radius is not to be
    //       randomly generated

    public BombItem (int radius) {
        super();
        this.radiusOfEffect = radius;
    }

    // MODIFIES: this
    // EFFECTS: changes the radiusOfEffect to the given int

    public void changeRadiusOfEffect(int radiusOfEffect) {
        this.radiusOfEffect = radiusOfEffect;
    }

    // GETTERS:

    // EFFECTS: return radiusEffect

    public int getRadiusOfEffect() {
        return radiusOfEffect;
    }
}
