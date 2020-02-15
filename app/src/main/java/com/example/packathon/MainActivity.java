package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // First page when app opens up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TODO:
    // "Start Packing" BUTTON  -> PlayerActivity
    // "High Scores"   BUTTON  -> ScoreboardActivity
}
