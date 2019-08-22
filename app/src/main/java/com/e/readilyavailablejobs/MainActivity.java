package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static com.e.readilyavailablejobs.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent Intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(Intent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
