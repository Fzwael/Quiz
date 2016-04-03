package com.if4.fzwael.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Fzwael on 4/1/2016.
 */
public class WelcomeActivity extends Activity{

    Button playbtn , hsbtn , exitbtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        playbtn = (Button) findViewById(R.id.playbtn);
        hsbtn = (Button) findViewById(R.id.hsbtn);
        exitbtn = (Button) findViewById(R.id.exitbtn);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });
        hsbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this,HighScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
