package com.example.planeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class GameActivity extends AppCompatActivity {

    private ImageView planeImageView;

    private ImageView imageViewMeteorite;

    private TextView timerTextView;



    private CountDownTimer countDownTimer;
    public boolean timerRunning;




    private long timeLeftInMilliseconds = 60000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        planeImageView = findViewById(R.id.planeImageView);
        timerTextView = findViewById(R.id.timerTextView);
        imageViewMeteorite = findViewById(R.id.imageViewMeteorite);


        JoystickView joystick = (JoystickView) findViewById(R.id.joystickView);


        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {

                if (angle > 315 || angle < 45) {

                    planeImageView.animate().translationXBy(20).translationYBy(0).setDuration(0);




                } else if (angle > 45 && angle < 135) {

                    planeImageView.animate().translationXBy(0).translationYBy(-20).setDuration(0);


                } else if (angle > 135 && angle < 225) {

                    planeImageView.animate().translationXBy(-20).translationYBy(0).setDuration(0);



                } else if (angle > 225 && angle < 315) {

                    planeImageView.animate().translationXBy(0).translationYBy(20).setDuration(0);

                }

            }

        });

        meteorRain();


        startTimer();


    }

    private void meteorRain() {

        imageViewMeteorite.animate().translationXBy(-1000).translationYBy(2000).setDuration(3000);



    }





    private void startTimer() {

        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timeLeftInMilliseconds = millisUntilFinished;

                updateTimer();

            }

            @Override
            public void onFinish() {

            }
        }.start();

        timerRunning = true;
    }

    private void updateTimer() {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLefText = "" + minutes;
        timeLefText += ":";

        if(seconds < 10) timeLefText +="0";
        timeLefText += seconds;

        timerTextView.setText(timeLefText);
    }





}
