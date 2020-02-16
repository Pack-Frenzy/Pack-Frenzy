package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class InBetweenTurnsActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 10000; // 10 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_over);

        countdownText = findViewById(R.id.countdownText);
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
