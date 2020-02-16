package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EndOfRoundActivity extends AppCompatActivity {
    // Scott, we coded this as though it is an in between stage
    TextView nameOfLoser;
    ArrayList<String> listOfPlayer;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_round);
        nameOfLoser = findViewById(R.id.loser);

        listOfPlayer = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (int i = 0; i < extras.size(); i++) {
                String playerName = extras.getString(String.valueOf(i));
                listOfPlayer.add(playerName);
            }
        }

        nameOfLoser.setText(listOfPlayer.get(listOfPlayer.size()-1));
//
//        recyclerView = (RecyclerView) findViewById(R.id.winners_losers);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        recyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        // specify an adapter (see also next example)
//        mAdapter = new RecyclerViewAdapter(listOfPlayer);
//        recyclerView.setAdapter(mAdapter);

    }
}