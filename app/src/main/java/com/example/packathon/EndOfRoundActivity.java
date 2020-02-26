package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EndOfRoundActivity extends AppCompatActivity {
    // Scott, we coded this as though it is an in between stage
    TextView nameOfLoser;
    ArrayList<String> listOfPlayer;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button endOfRound;
    private int numCurrentRound;
    private TextView playerLeft1;
    private TextView playerLeft2;
    private TextView playerLeft3;
    private ArrayList<TextView> listOfViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_round);
        nameOfLoser = findViewById(R.id.loser);

        listOfPlayer = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numCurrentRound = extras.getInt("currentRound");
            for (int i = 0; i < extras.size() - 1; i++) {
                String playerName = extras.getString(String.valueOf(i));
                listOfPlayer.add(playerName);
                System.out.println(playerName);
            }
        }

        nameOfLoser.setText(listOfPlayer.get(listOfPlayer.size()-1));
        endOfRound = findViewById(R.id.end_of_round);
        listOfPlayer.set(listOfPlayer.size() - 1, "Eliminated");

        playerLeft1 = findViewById(R.id.player_left_1);
        playerLeft2 = findViewById(R.id.player_left_2);
        playerLeft3 = findViewById(R.id.player_left_3);
        listOfViews.add(playerLeft1);
        listOfViews.add(playerLeft2);
        listOfViews.add(playerLeft3);

        for (int i = 0; i < listOfPlayer.size() - 1; i++) {
            if (!listOfPlayer.get(i).equals("Eliminated")) {
                listOfViews.get(i).setText(listOfPlayer.get(i));
            } else {
                listOfViews.get(i).setText("");
            }
        }

        endOfRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoundActivity();
            }
        });
    }

    // EFFECTS: turns off the function of the back button
    @Override
    public void onBackPressed() {

    }

    public void openRoundActivity() {
        Intent intent = new Intent(this, RoundActivity.class);
        for (int i = 0; i < listOfPlayer.size(); i++) {
            intent.putExtra(Integer.toString(i), listOfPlayer.get(i));
        }
        intent.putExtra("currentRound", numCurrentRound);

        startActivity(intent);
    }
}