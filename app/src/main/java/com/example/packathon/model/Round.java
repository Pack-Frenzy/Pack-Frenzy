package com.example.packathon.model;

import java.util.ArrayList;

public class Round {
    private Box box;
    private ArrayList<Turn> turns;
    private int numOfPlayers;

    public Round(ArrayList<Player> players) {
        numOfPlayers = players.size();
        box = new Box(numOfPlayers);
    }

    public int getNumberOfPlayers() {
        return numOfPlayers;
    }
}