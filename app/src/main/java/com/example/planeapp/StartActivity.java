package com.example.planeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startButton = findViewById(R.id.buttonStart);

    }


    public void startGameActivity(View view) {
        Intent intent = new Intent(StartActivity.this, GameActivity.class);
        startActivity(intent);

    }
}