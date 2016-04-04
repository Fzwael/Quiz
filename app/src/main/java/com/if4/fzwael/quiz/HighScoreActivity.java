package com.if4.fzwael.quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Fzwael on 4/3/2016.
 */
public class HighScoreActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        TextView textResult = (TextView) findViewById(R.id.hstxt);
        SharedPreferences prefs = this.getSharedPreferences("highScore", Context.MODE_PRIVATE);
        int score = prefs.getInt("key", 0); //0 is the default value

    }
}
