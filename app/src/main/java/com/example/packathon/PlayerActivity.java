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
import com.example.packathon.popups.MinPlayersPopup;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {
    private Button roundActivity;
    private String player1;
    private String player2;
    private String player3;
    private String player4;
    private EditText playerOne;
    private EditText playerTwo;
    private EditText playerThree;
    private EditText playerFour;
    private Intent intent;
    private List<String> activePlayers;

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
                intent = new Intent(PlayerActivity.this, RoundActivity.class);
                setPlayerNamesForGame(intent);
                if (activePlayers.size() <= 1) {
                    startActivity(new Intent(PlayerActivity.this, MinPlayersPopup.class));
                } else {
                    openRoundActivity();
                }
            }
        });
    }

    public void openRoundActivity() {
        intent.putExtra("currentRound", 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void setPlayerNamesForGame(Intent intent) {
        EditText[] editNames = new EditText[] {playerOne, playerTwo, playerThree, playerFour};
        String[] names = new String[] {player1, player2, player3, player4};
        activePlayers = new ArrayList<>();
        for (EditText editName : editNames) {
            editName.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        for (int i = 0; i < names.length; i++) {
            names[i] = editNames[i].getText().toString();
            if(!names[i].equals("")) {
                activePlayers.add(i + names[i]);
            }
        }
        passPlayerNamesToNextActivity(intent, activePlayers);
    }

    private void passPlayerNamesToNextActivity(Intent intent, List<String> activePlayers) {
        for (int i = 0; i < activePlayers.size(); i++) {
            intent.putExtra(Integer.toString(i), activePlayers.get(i));
        }
    }
}
