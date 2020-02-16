package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

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

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        EditText playerThree = findViewById(R.id.playerThree);
        EditText playerFour = findViewById(R.id.playerFour);

        playerOne.setInputType(InputType.TYPE_CLASS_TEXT);
        playerTwo.setInputType(InputType.TYPE_CLASS_TEXT);
        playerThree.setInputType(InputType.TYPE_CLASS_TEXT);
        playerFour.setInputType(InputType.TYPE_CLASS_TEXT);

        player1 = playerOne.getText().toString();
        player2 = playerTwo.getText().toString();
        player3 = playerThree.getText().toString();
        player4 = playerFour.getText().toString();

        intent.putExtra("playerOne", player1);
        intent.putExtra("playerTwo", player2);
        intent.putExtra("playerThree", player3);
        intent.putExtra("playerFour", player4);

        startActivity(intent);
    }

    // TODO:
    // "Finalize Players" BUTTON  -> RoundActivity
}
