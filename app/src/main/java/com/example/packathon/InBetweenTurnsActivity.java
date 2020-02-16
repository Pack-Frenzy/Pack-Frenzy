package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.ArrayList;

public class InBetweenTurnsActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 10000; // 10 seconds
<<<<<<< HEAD
=======
    private boolean timeRunning;
    private ArrayList<String> playerNames;
>>>>>>> 21df2a05b99e5805be42da01c856568820a31d98

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_between_turns);

<<<<<<< HEAD
        countdownText = findViewById(R.id.countdownText);
=======
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

>>>>>>> 21df2a05b99e5805be42da01c856568820a31d98
        startTimer();
    }

    public void startTimer() {
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
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
        startActivity(intent);
    }

}
