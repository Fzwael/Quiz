package com.if4.fzwael.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Fzwael on 4/6/2016.
 */
public class LiveActivity extends Activity {
    TextView codeinput;
    Button liveplaybtn , downloadbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        codeinput = (TextView) findViewById(R.id.codeinput);
        liveplaybtn = (Button) findViewById(R.id.liveplaybtn);
        downloadbtn = (Button) findViewById(R.id.downloadbtn);

        liveplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LiveActivity.this,QuestionActivity.class);
                Bundle b = new Bundle();
                b.putString("choice",codeinput.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }
}
