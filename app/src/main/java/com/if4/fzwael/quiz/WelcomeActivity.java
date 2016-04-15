package com.if4.fzwael.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Fzwael on 4/1/2016.
 */
public class WelcomeActivity extends Activity{

    Button playbtn , hsbtn , exitbtn , playlivebtn , aboutbnt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        playbtn = (Button) findViewById(R.id.playbtn);
        playlivebtn = (Button) findViewById(R.id.playlivebtn);
        hsbtn = (Button) findViewById(R.id.hsbtn);
        exitbtn = (Button) findViewById(R.id.exitbtn);
        aboutbnt = (Button) findViewById(R.id.aboutbtn);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,QuestionActivity.class);
                Bundle b = new Bundle();
                b.putString("choice","local");
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });

        playlivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,LiveActivity.class);
                startActivity(intent);
                finish();
            }
        });

        hsbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,HighScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });

        aboutbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                WelcomeActivity.this.finish();
            }
        });
    }
}
