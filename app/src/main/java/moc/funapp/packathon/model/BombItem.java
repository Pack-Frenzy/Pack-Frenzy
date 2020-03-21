package moc.funapp.packathon.model;

import android.graphics.Color;

import java.util.Random;

public class BombItem extends BoxItem {
    private int radiusOfEffect;

    public BombItem() {
        Random random = new Random();
        this.weight = random.nextInt(3) + 2;
    }

    // NOTE: this constructor is to be used when radius is not to be
    //       randomly generated

    public BombItem (int radius) {
        super();
        this.weight = radius;
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
