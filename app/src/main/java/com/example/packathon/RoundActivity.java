package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.packathon.model.Player;
import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    // TODO: must adjust round based on the round number
    private TextView round;

    // TODO: must adjust based on how many players there are
    private ArrayList<Player> players;
    private ArrayList<String> playerNames;
    private ArrayList<TextView> playerTextViews;
    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        // must bind player data to list

        players = new ArrayList<>();
        playerNames = new ArrayList<>();
        playerTextViews = new ArrayList<>();
        round = findViewById(R.id.textViewRound);
        player1 = findViewById(R.id.textViewPlayer1);
        player2 = findViewById(R.id.textViewPlayer2);
        player3 = findViewById(R.id.textViewPlayer3);
        player4 = findViewById(R.id.textViewPlayer4);
        playerTextViews.add(player1);
        playerTextViews.add(player2);
        playerTextViews.add(player3);
        playerTextViews.add(player4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String playerName = extras.getString("playerOne");
            playerNames.add(playerName);

            playerName = extras.getString("playerTwo");
            playerNames.add(playerName);

            playerName = extras.getString("playerThree");
            playerNames.add(playerName);

            playerName = extras.getString("playerFour");
            playerNames.add(playerName);
        }

        // TODO: must pull list of players from round

        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }

        // TODO: must refactor based on what is being fed into this class
        // TODO: change how empty names show
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName() == "") {
                playerTextViews.get(i).setText("");
            } else {
                playerTextViews.get(i).setText(String.valueOf(i + 1) + ". " + players.get(i).getName());
            }
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
