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

    private Button goHome;
    private TextView winner;


    // TODO: add a Play Again button which takes to PlayerActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_game_over);
        goHome = findViewById(R.id.goHome);
        winner = findViewById(R.id.winner);
    }

    @Override
    protected void onResume() {
        super.onResume();
        extractBundle();
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {}

    private void extractBundle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String winnerText = extras.get("winner").toString();
            winner.setText(winnerText.substring(1));
        }
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
