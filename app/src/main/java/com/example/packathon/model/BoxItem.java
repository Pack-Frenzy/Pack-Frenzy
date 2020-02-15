package com.example.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class BoxItem {

    public static final int SIZE_X = 100;
    public static final int SIZE_Y = 100;

    protected Color colour;
    protected int x;
    protected int y;
    protected int weight;

    public BoxItem(int x, int y, Color colour) {
        Random random = new Random();
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.weight = random.nextInt(20) + 1;
    }

    // NOTE: this constructor is to be used when weight is not to be
    //       randomly generated

    public BoxItem(int x, int y, Color colour, int weight) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.weight = weight;
    }

    // MODIFIES: this
    // EFFECTS: changes this.x to given int

    public void changeX(int newX) {
        this.x = newX;
    }

    // MODIFIES: this
    // EFFECTS: changes this.y to given int

    public void changeY(int newY) {
        this.y = newY;
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

    // EFFECTS: returns x

    public int getX() {
        return x;
    }

    // EFFECTS: returns y

    public int gety() {
        return y;
    }



}
