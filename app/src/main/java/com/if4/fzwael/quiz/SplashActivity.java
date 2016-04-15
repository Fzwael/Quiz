package com.if4.fzwael.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

/**
 * Created by Fzwael on 4/14/2016.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemClock.sleep(TimeUnit.SECONDS.toMillis(1));
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}