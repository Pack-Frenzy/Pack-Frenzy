package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class BoxItem {

    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 100;

    protected double weight;


    public BoxItem() {
        Random random = new Random();
        this.weight = random.nextInt(20) + 1;
    }

    // NOTE: this constructor is to be used when weight is not to be
    //       randomly generated

    public BoxItem(int weight) {
        this.weight = weight;
    }



    // MODIFIES: this
    // EFFECTS; changes this.weight to given int

    public void changeWeight(int newWeight) {
        this.weight = newWeight;
    }


    // EFFECTS: returns weight

    public double getWeight() {
        return weight;
    }

    public double getWeightDouble() {
        return weight;
    }



}
