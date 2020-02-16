package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.packathon.model.Player;
import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    // TODO: must adjust based on how many players there are
    private ArrayList<Player> players;
    private ArrayList<String> playerNames;
    private ArrayList<TextView> playerTextViews;
    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;
    private int numCurrentRound;

    public Button startTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        // must bind player data to list

        players = new ArrayList<>();
        playerNames = new ArrayList<>();
        playerTextViews = new ArrayList<>();
        TextView currentRound = findViewById(R.id.textViewRound);
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

            // get current round number
            numCurrentRound = extras.getInt("currentRound") + 1;

            for (int i = 0; i < extras.size() - 1; i++) {
                String playerName = extras.getString(Integer.toString(i));
                playerNames.add(playerName);
            }
        }

        // TODO: must pull list of players from currentRound

        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }

        // TODO: must refactor based on what is being fed into this class
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals("") || players.get(i).getName().equals("Eliminated")) {
                playerTextViews.get(i).setText(null);
            } else {
                playerTextViews.get(i).setText(String.format("Player %s: %s",
                        String.valueOf(i + 1), players.get(i).getName()));
            }
        }

        currentRound.setText(String.format("Round %s", numCurrentRound));

        startTurn = findViewById(R.id.start_turn);

        startTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTurnActivity();
            }
        });

    }

    public void openTurnActivity() {
        Intent intent = new Intent(this, StartOfRoundActivity.class);
        for (int i = 0; i < playerNames.size(); i++) {
            if (!players.get(i).getName().equals("") && !players.get(i).getName().equals("Eliminated")) {
                intent.putExtra(Integer.toString(i), playerNames.get(i));
            }
        }
        intent.putExtra("currentRound", numCurrentRound);
        startActivity(intent);
    }

}
