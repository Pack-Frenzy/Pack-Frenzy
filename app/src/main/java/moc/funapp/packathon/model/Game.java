package moc.funapp.packathon.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Player> players;
    private final int MAX_PLAYERS = 4;
    private int roundNum;
    private HashMap<String, Integer> allScores;

    public Game(ArrayList<Player> players) {
        this.players = players;
        roundNum = 1;
    }

    public void eliminatePlayer(Player loser) {
        String name = loser.getName();
        Integer score = loser.getScore();
        players.remove(loser);
        roundNum += 1;
        allScores.put(name, score);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getRoundNumber(int index) {
        return roundNum;
    }
}
