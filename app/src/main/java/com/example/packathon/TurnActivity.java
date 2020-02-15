package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TurnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);
    }

    // TODO:
    // If round is over, go to RoundActivity
    // Else InBetweenTurnsActivity
}
