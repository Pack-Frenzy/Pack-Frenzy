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

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {
    String player1;
    String player2;
    String player3;
    String player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_player);

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

        intent.putExtra("0", player1);
        intent.putExtra("1", player2);
        intent.putExtra("2", player3);
        intent.putExtra("3", player4);
        intent.putExtra("currentRound", 0);

        startActivity(intent);
    }
}
