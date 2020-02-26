package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
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
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        introMusic = MediaPlayer.create(MainActivity.this, R.raw.intro);
        introMusic.start();

        Button playerActivity = findViewById(R.id.startPacking);
        Button instructionsActivity = findViewById(R.id.instructionsButton);

        playerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayerActivity();
            }
        });

        instructionsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openInstructionsActivity();
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

    public void openInstructionsActivity() {
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    // TODO:
    // "Start Packing" BUTTON  -> PlayerActivity
    // "High Scores"   BUTTON  -> ScoreboardActivity
}
