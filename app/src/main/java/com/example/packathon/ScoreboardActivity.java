package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScoreboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Button home = findViewById(R.id.homeButton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameOverActivity();
            }
        });
    }

    // TODO: Change this back to home... inbetweenturns is just for testing
    public void openGameOverActivity() {
        Intent intent = new Intent(this, RoundOverActivity.class);

        startActivity(intent);
    }
}
