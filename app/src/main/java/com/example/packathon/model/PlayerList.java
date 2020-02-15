package com.example.packathon.model;

import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> playerList;
    int numPlayers;
    int MAX_NUMBER_OF_PLAYERS = 5;

    public PlayerList() {
        playerList = new ArrayList<>();
        numPlayers = 0;
    }

    // add players until done, or until max number of players is reached
    public void addPlayer(Player p) {
        playerList.add(p);
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Player getPlayerAtIndex(int index) {
        return playerList.get(index);
    }

    public void deletePlayer(int index) {
        playerList.remove(index);
    }

    public int getNumPlayers() {
        return numPlayers;
    }

}
