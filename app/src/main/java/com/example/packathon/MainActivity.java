package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // First page when app opens up

    private MediaPlayer introMusic;
    private int mediaLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introMusic = MediaPlayer.create(MainActivity.this, R.raw.intro);
        introMusic.start();

        Button playerActivity = findViewById(R.id.startPacking);
        Button scoreboardActivity = findViewById(R.id.scoreBoard);

        playerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayerActivity();
            }
        });

        scoreboardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreboardActivity();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (introMusic != null) {
            introMusic.start();
            introMusic.seekTo(mediaLength);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (introMusic != null) {
            introMusic.pause();
            mediaLength = introMusic.getCurrentPosition();
        }
    }

    public void openPlayerActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }

    public void openScoreboardActivity() {
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }

    // TODO:
    // "Start Packing" BUTTON  -> PlayerActivity
    // "High Scores"   BUTTON  -> ScoreboardActivity
}
