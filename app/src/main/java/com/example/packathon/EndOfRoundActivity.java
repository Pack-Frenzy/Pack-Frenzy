package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EndOfRoundActivity extends AppCompatActivity {
    private TextView nameOfLoser;
    private String[] players;
    private Button endOfRound;
    private int numCurrentRound;
    private TextView playerLeft1;
    private TextView playerLeft2;
    private TextView playerLeft3;
    private ArrayList<TextView> listOfViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_end_of_round);

        nameOfLoser = findViewById(R.id.loser);
        endOfRound = findViewById(R.id.end_of_round);

        playerLeft1 = findViewById(R.id.player_left_1);
        playerLeft2 = findViewById(R.id.player_left_2);
        playerLeft3 = findViewById(R.id.player_left_3);
        listOfViews.add(playerLeft1);
        listOfViews.add(playerLeft2);
        listOfViews.add(playerLeft3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        extractBundle();
        nameOfLoser.setText(players[players.length - 1]);
        getEliminatedPlayer();
        endOfRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoundActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {}

    private void getEliminatedPlayer() {
        players[players.length - 1] = "Eliminated";
        for (int i = 0; i < players.length - 1; i++) {
            if (!players[i].equals("Eliminated")) {
                listOfViews.get(i).setText(players[i]);
            } else {
                listOfViews.get(i).setText("");
            }
        }
    }

    private void extractBundle() {
        Bundle extras = getIntent().getExtras();
        int bundleSize = extras.size();
        players = new String[bundleSize - 1];
        if (extras != null) {
            numCurrentRound = extras.getInt("currentRound") + 1;
            for (int i = 0; i < bundleSize - 1; i++) {
                String playerName = extras.getString(Integer.toString(i));
                players[i] = playerName;
            }
        }
    }

    private void openRoundActivity() {
        Intent intent = new Intent(this, RoundActivity.class);
        for (int i = 0; i < players.length; i++) {
            intent.putExtra(Integer.toString(i), players[i]);
        }
        intent.putExtra("currentRound", numCurrentRound);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}