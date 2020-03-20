package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StartOfRoundActivity extends AppCompatActivity {
    // TODO: add facial recognition here

    private Button skipButton;
    private TextView countdownText;
    private TextView currentPlayerFromID;
    private long timeLeftInMilliseconds;
    private String[] players;
    private int numCurrentRound;
    boolean skipped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_start_of_round);
        countdownText = findViewById(R.id.countdownText);
        currentPlayerFromID = findViewById(R.id.currentPlayer);
        skipButton = findViewById(R.id.skipButton);
    }

    protected void onResume() {
        super.onResume();
        extractBundle();
        String currentPlayer = players[0];
        currentPlayerFromID.setText(currentPlayer.substring(1));
        timeLeftInMilliseconds = 10000;
        toTurnActivity();
    }

    private void extractBundle() {
        Bundle extras = getIntent().getExtras();
        int bundleSize = extras.size();
        players = new String[bundleSize - 1];
        if (extras != null) {
            numCurrentRound = extras.getInt("currentRound");
            for (int i = 0; i < bundleSize - 1; i++) {
                String playerName = extras.getString(Integer.toString(i));
                players[i] = playerName;
            }
        }
    }

    private void toTurnActivity() {
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipped = true;
                openTurnActivity();
            }
        });
        startTimer();
    }

    private void startTimer() {
        CountDownTimer timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(skipped) {
                    onFinish();
                } else {
                    timeLeftInMilliseconds = millisUntilFinished;
                    updateTimer();
                }

            }
            @Override
            public void onFinish() {
                if (!skipped) {
                    openTurnActivity();
                }
            }
        }.start();
    }

    private void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;
        int minutes = 0;

        String timeLeftText = String.format("%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftText);
    }

    private void openTurnActivity() {
        Intent intent = new Intent(this, TurnActivity.class);
        for (int i = 0; i < players.length; i++) {
            if (!players[i].equals("") && !players[i].equals("Eliminated")) {
                intent.putExtra(Integer.toString(i), players[i]);
            }
        }
        intent.putExtra("currentRound", numCurrentRound);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
