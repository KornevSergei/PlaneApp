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

    private ImageView imageViewMeteorite1;
    private ImageView imageViewMeteorite2;
    private ImageView imageViewMeteorite3;
    private ImageView imageViewMeteorite4;

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
        imageViewMeteorite1 = findViewById(R.id.imageViewMeteorite1);
        imageViewMeteorite2 = findViewById(R.id.imageViewMeteorite2);
        imageViewMeteorite3 = findViewById(R.id.imageViewMeteorite3);
        imageViewMeteorite4 = findViewById(R.id.imageViewMeteorite4);


        JoystickView joystick = (JoystickView) findViewById(R.id.joystickView);


        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {


                //вправо
                if (angle > 315 || angle < 45) {

                    planeImageView.animate().translationXBy(20).translationYBy(0).setDuration(0);
                    planeImageView.animate().rotation(planeImageView.getRotation() + 3);

                    //вверх
                } else if (angle > 45 && angle < 135) {

                    planeImageView.animate().translationXBy(0).translationYBy(-20).setDuration(0);
                    planeImageView.animate().rotation(planeImageView.getRotation() + 3);


                    //влево
                } else if (angle > 135 && angle < 225) {

                    planeImageView.animate().translationXBy(-20).translationYBy(0).setDuration(0);
                    planeImageView.animate().rotation(planeImageView.getRotation() + 3);


                    //вниз
                } else if (angle > 225 && angle < 315) {

                    planeImageView.animate().translationXBy(0).translationYBy(20).setDuration(0);
                    planeImageView.animate().rotation(planeImageView.getRotation() + 3);

                }

            }

        });

        meteorRain();


        startTimer();


    }

    private void meteorRain() {

        imageViewMeteorite1.animate().translationXBy(-1000).translationYBy(2000).setDuration(7000);

        imageViewMeteorite2.animate().translationXBy(-600).translationYBy(2000).setDuration(6000);

        imageViewMeteorite3.animate().translationXBy(1500).translationYBy(-800).setDuration(9000);

        imageViewMeteorite4.animate().translationXBy(500).translationYBy(2000).setDuration(20000);


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

        if (seconds < 10) timeLefText += "0";
        timeLefText += seconds;

        timerTextView.setText(timeLefText);
    }


}
