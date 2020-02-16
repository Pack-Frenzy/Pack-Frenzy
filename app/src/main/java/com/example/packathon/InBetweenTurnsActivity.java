package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.ArrayList;

public class InBetweenTurnsActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 10000; // 10 seconds
    private boolean timeRunning;
    private ArrayList<String> playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_between_turns);

        countdownText = findViewById(R.id.countdown_text);

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
        }

        startTimer();

    }

    public void startTimer() {
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = 1;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timeRunning = true;
    }

    public void stopTimer() {
        timer.cancel();
        timeRunning = false;
    }

    public void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText = "";

        if (seconds < 10) timeLeftText += "0";

        countdownText.setText(timeLeftText);
    }


    // TODO:
    // Countdown from 10 -> TurnActivity
}
