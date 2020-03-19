package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    Button roundActivity;
    String player1;
    String player2;
    String player3;
    String player4;
    EditText playerOne;
    EditText playerTwo;
    EditText playerThree;
    EditText playerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_player);

        roundActivity = findViewById(R.id.submitPlayers);

        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        playerThree = findViewById(R.id.playerThree);
        playerFour = findViewById(R.id.playerFour);

    }

    @Override
    protected void onResume() {
        super.onResume();

        roundActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoundActivity();
            }
        });
    }

    public void openRoundActivity() {
        Intent intent = new Intent(this, RoundActivity.class);
        setPlayerNamesForGame(intent);
        intent.putExtra("currentRound", 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void setPlayerNamesForGame(Intent intent) {
        EditText[] editNames = new EditText[] {playerOne, playerTwo, playerThree, playerFour};
        String[] names = new String[] {player1, player2, player3, player4};
        ArrayList<String> activePlayers = new ArrayList<>();
        for (EditText editName : editNames) {
            editName.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = editNames[i].getText().toString();
            if(!names[i].equals("")) {
                activePlayers.add(names[i]);
            }
        }

        passPlayerNamesToNextActivity(intent, activePlayers);
    }


    private void passPlayerNamesToNextActivity(Intent intent, ArrayList<String> activePlayers) {
        for (int i = 0; i < activePlayers.size(); i++) {
            intent.putExtra(Integer.toString(i), activePlayers.get(i));
        }
    }
}
