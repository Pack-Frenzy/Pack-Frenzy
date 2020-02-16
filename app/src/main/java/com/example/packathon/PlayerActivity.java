package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayerActivity extends AppCompatActivity {
    String player1;
    String player2;
    String player3;
    String player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Button roundActivity = findViewById(R.id.submitPlayers);

        roundActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoundActivity();
            }
        });
    }

    public void openRoundActivity() {
        Intent intent = new Intent(this, RoundActivity.class);
        startActivity(intent);
    }

    // TODO:
    // "Finalize Players" BUTTON  -> RoundActivity
}
