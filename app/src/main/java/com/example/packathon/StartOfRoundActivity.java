package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.ArrayList;

public class StartOfRoundActivity extends AppCompatActivity {

    private TextView countdownText;
    private TextView currentPlayerFromID;

    // TODO: change back to 10000 secs, 1000 just for testing
    private long timeLeftInMilliseconds = 10000; // 10 seconds
    private ArrayList<String> playerNames;
    private int numCurrentRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_of_round);

        countdownText = findViewById(R.id.countdownText);

        playerNames = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String playerName = extras.getString("0");
            playerNames.add(playerName);

            playerName = extras.getString("1");
            playerNames.add(playerName);

            playerName = extras.getString("2");
            playerNames.add(playerName);

            playerName = extras.getString("3");
            playerNames.add(playerName);

            numCurrentRound = extras.getInt("currentRound");
        }

        currentPlayerFromID = findViewById(R.id.currentPlayer);
        String currentPlayer = playerNames.get(0);

        currentPlayerFromID.setText(currentPlayer);

        startTimer();
    }

    public void startTimer() {
        CountDownTimer timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }


            @Override
            public void onFinish() {
                openTurnActivity();
            }
        }.start();
    }

    public void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;
        int minutes = 0;

        String timeLeftText = String.format("%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftText);
    }

    public void openTurnActivity() {
        Intent intent = new Intent(this, TurnActivity.class);
        for (int i = 0; i < playerNames.size(); i++) {
            intent.putExtra(Integer.toString(i), playerNames.get(i));
        }

        intent.putExtra("currentRound", numCurrentRound);

        startActivity(intent);
    }

}
