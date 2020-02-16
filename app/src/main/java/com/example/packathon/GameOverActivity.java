package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class GameOverActivity extends AppCompatActivity {
    // Scott, we coded this as though it is an in between stage
    TextView nameOfLoser;
    ArrayList<String> listOfPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        nameOfLoser = findViewById(R.id.textView4);

        listOfPlayer = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (int i = 0; i < extras.size(); i++) {
                String playerName = extras.getString(String.valueOf(i));
                listOfPlayer.add(playerName);
            }
        }
        nameOfLoser.setText(listOfPlayer.get(listOfPlayer.size()-1), TextView.BufferType.EDITABLE);
    }

    // TODO:
    // "Home" BUTTON  -> MainActivity
}