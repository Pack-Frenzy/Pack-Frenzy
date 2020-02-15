package com.example.packathon.model;

public class Round {
    int currentRound;
    Turn currentTurn;
    Player currentPlayer;
    PlayerList playerList;

    public Round() {
        currentRound = 0;
        currentTurn = new Turn();
        currentPlayer = new Player();
        playerList = new PlayerList();
    }

    public void nextRound() {
        currentRound++;
    }

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

}