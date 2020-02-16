package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class BoxItem {

    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 100;

    protected Color colour;
    protected int weight;

    public BoxItem() {
        Color color = new Color();
        Random random = new Random();
        this.colour = color.valueOf((random.nextInt(255 + 1)),
                (random.nextInt(255 + 1)),
                (random.nextInt(255 + 1)));
        this.weight = random.nextInt(20) + 1;
    }

    public BoxItem(Color colour) {
        Random random = new Random();
        this.colour = colour;
        this.weight = random.nextInt(20) + 1;
    }

    // NOTE: this constructor is to be used when weight is not to be
    //       randomly generated

    public BoxItem(Color colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }


    // MODIFIES: this
    // EFFECTS: changes this.colour to given colour

    public void changeColour(Color colour) {
        this.colour = colour;
    }

    // MODIFIES: this
    // EFFECTS; changes this.weight to given int

    public void changeWeight(int newWeight) {
        this.weight = newWeight;
    }

    // EFFECTS: returns weight

    public int getWeight() {
        return weight;

    }



}
