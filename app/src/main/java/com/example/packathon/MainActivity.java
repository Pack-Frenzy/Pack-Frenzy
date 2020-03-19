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

    // TODO: add utility class for common methods
    // TODO: add music to rest of activities
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
        } else {
            introMusic.start();
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

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void openPlayerActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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
}
