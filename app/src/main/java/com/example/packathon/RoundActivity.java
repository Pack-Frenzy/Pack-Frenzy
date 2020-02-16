package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.packathon.model.Game;
import com.example.packathon.model.Player;
import com.example.packathon.model.Round;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    // TODO: must adjust round based on the round number
    private View round = findViewById(R.id.textViewRound);

    // TODO: must adjust based on how many players there are
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<TextView> playerTextViews = new ArrayList<>();
    private TextView player1 = findViewById(R.id.textViewPlayer1);
    private TextView player2 = findViewById(R.id.textViewPlayer2);
    private TextView player3 = findViewById(R.id.textViewPlayer3);
    private TextView player4 = findViewById(R.id.textViewPlayer4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        // must bind player data to list

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String player1 = extras.getString("playerOne");
//        }

        // TODO: must pull list of players from round
        Player eric = new Player("Eric");
        Player scott = new Player("Scott");
        Player ben = new Player("Ben");
        Player anthony = new Player("Anthony");
        players.add(eric);
        players.add(scott);
        players.add(ben);
        players.add(anthony);

        // TODO: must refactor based on what is being fed into this class
        for (int i = 0; i < players.size(); i++) {
            if (playerTextViews.get(i) == null) {
                playerTextViews.get(i).setText("");
            }
            playerTextViews.get(i).setText(String.valueOf(i) + players.get(i).getName());
        }

        // TODO: must refactor to generate the number of blanks for each player


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
