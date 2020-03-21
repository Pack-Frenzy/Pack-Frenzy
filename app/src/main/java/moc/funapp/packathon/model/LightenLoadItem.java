package moc.funapp.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class LightenLoadItem extends BoxItem {

    private double effectSize; // multiplied to weight of box to reduce weight
                            // will range from .5 - .9


    public LightenLoadItem () {
        Random random = new Random();
        this.weight = (random.nextInt(40) + 50);
    }

    // EFFECTS: changes this.effectSize to given int

    public void changeEffectSize(double effectSize) {
        this.effectSize = effectSize;
    }

    public double getEffectSize() {
        return effectSize;
    }
}
