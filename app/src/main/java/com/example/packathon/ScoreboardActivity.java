package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ScoreboardActivity extends AppCompatActivity {
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_scoreboard);
        home = findViewById(R.id.homeButton);
    }

    protected void onResume() {
        super.onResume();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameOverActivity();
            }
        });
    }

    public void openGameOverActivity() {
        Intent intent = new Intent(this, EndOfRoundActivity.class);
        startActivity(intent);
    }
}
