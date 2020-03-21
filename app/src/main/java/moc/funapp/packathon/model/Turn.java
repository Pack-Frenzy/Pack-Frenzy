package moc.funapp.packathon.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Timer;

public class Turn {
    private int currentTurn;
    private Timer timer;
    private Player currentPlayer;
    private ArrayList<BoxItem> boxItemList;

    private static final int NUM_ITEMS_IN_LIST = 50;

    public Turn() {
        int currentTurn = 1;
        timer = new Timer();
        currentPlayer = new Player();
        boxItemList = new ArrayList<>();
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void nextTurn() {
        currentTurn++;
    }

    public void populateboxItemList() {
        for (int i = 0; i < NUM_ITEMS_IN_LIST; i++) {
            Color color = new Color();
            // randomize color
            // randomize weight
            // randomize size
        }
    }


}
