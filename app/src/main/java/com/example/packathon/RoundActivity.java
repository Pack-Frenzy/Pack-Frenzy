package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    // TODO: must adjust TextView based on how many players there are
    // TODO: add a back button to add more players
    private String[] players;
    private TextView[] playerTextViews;
    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;
    private TextView currentRound;
    private int numCurrentRound;
    private Button startTurn;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_round);
        playerTextViews = new TextView[] {
            player1 = findViewById(R.id.textViewPlayer1),
            player2 = findViewById(R.id.textViewPlayer2),
            player3 = findViewById(R.id.textViewPlayer3),
            player4 = findViewById(R.id.textViewPlayer4)
        };
        currentRound = findViewById(R.id.textViewRound);
        startTurn = findViewById(R.id.start_turn);
        backButton = findViewById(R.id.backButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        extractBundle();
        setTextView();
        currentRound.setText(String.format("Round %s", numCurrentRound));

        startTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTurnActivity();
            }
        });


        if (numCurrentRound != 1) {
            backButton.setVisibility(View.GONE);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayerActivity();
            }
        });
    }

    private void extractBundle() {
        Bundle extras = getIntent().getExtras();
        int bundleSize = extras.size();
        players = new String[bundleSize - 1];
        if (extras != null) {
            numCurrentRound = extras.getInt("currentRound") + 1;
            for (int i = 0; i < bundleSize - 1; i++) {
                String playerName = extras.getString(Integer.toString(i));
                players[i] = playerName;
            }
        }
    }

    private void setTextView() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals("Eliminated")) {
                playerTextViews[i].setText(null);
            } else {
                playerTextViews[i].setText(String.format("Player %s: %s", String.valueOf(i + 1), players[i]));
            }
        }
    }

    private void openTurnActivity() {
        Intent intent = new Intent(this, StartOfRoundActivity.class);
        for (int i = 0; i < players.length; i++) {
            if (!players[i].equals("") && !players[i].equals("Eliminated")) {
                intent.putExtra(Integer.toString(i), players[i]);
            }
        }
        intent.putExtra("currentRound", numCurrentRound);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void openPlayerActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
