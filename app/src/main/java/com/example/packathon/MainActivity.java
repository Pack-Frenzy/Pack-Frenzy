package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // First page when app opens up

    private MediaPlayer introMusic;
    private int mediaLength;

    private Button playerActivity;
    private Button instructionsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_main);

        introMusic = MediaPlayer.create(MainActivity.this, R.raw.intro);

        if (introMusic != null) {
            introMusic.start();
            introMusic.seekTo(mediaLength);
        } else {
            introMusic.start();
        }


        playerActivity = findViewById(R.id.startPacking);
        instructionsActivity = findViewById(R.id.instructionsButton);
    }


    @Override
    protected void onResume() {
        super.onResume();

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
