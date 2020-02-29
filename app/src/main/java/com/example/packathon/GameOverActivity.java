package com.example.packathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_game_over);

        Button goHome = findViewById(R.id.goHome);

        TextView winner = findViewById(R.id.winner);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String winnerText = extras.get("winner").toString();
            winner.setText(winnerText);
        }


        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    // EFFECTS: turns off the function of the back button
    @Override
    public void onBackPressed() {

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, PlayerActivity.class);
        startActivity(intent);
    }
}
