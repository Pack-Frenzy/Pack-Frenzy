package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class InBetweenTurnsActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 10000; // 10 seconds
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_over);

        countdownText = findViewById(R.id.countdown_text);
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
