package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.packathon.model.Player;
import com.example.packathon.model.PlayerList;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    // TODO: must adjust round based on the round number
    private View round = findViewById(R.id.textViewRound);

    // TODO: must adjust based on how many players there are
    private int numOfPlayers = 4;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<String> playerNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        // must bind player data to list

        // Create list of players

        // TODO: must refactor based on what is being fed into this class
        PlayerList listOfPlayers = new PlayerList(4);
        for (Player player : listOfPlayers.getListOfPlayers()) {
            players.add(player);
        }

        // Bind each player to name

    }

    // Display what the current round is


    // From model.Round
    // Display the order of players
    // From model.Round
    // Only show up for maybe 10 seconds? -> TurnActivity

    // TODO:
    // Countdown from 10 -> TurnActivity
}
