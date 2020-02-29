package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Button goHome = findViewById(R.id.goHome);

        TextView winner = findViewById(R.id.winner);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String winnerText = extras.get("winner").toString();
            winner.setText(winnerText);
        }


        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    // EFFECTS: turns off the function of the back button
    @Override
    public void onBackPressed() {

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}
