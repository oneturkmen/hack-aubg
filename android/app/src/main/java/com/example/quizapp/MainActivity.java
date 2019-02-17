package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    Button add;
    Button stop;
    Button open;
    Alarm alarm = new Alarm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MainActivity");
        Intent intent = getIntent();
        String xmlString = intent.getStringExtra("TextBox");



        btnStart=(Button) findViewById(R.id.StartBtn);
        stop=(Button) findViewById(R.id.stopService);
        add=(Button) findViewById(R.id.addQuiz);
        open=(Button) findViewById(R.id.owp);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm.setAlarm(getApplicationContext());
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm.cancelAlarm(getApplicationContext());
            }
        } );
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(MainActivity.this, FilePickerActivity.class)
                );
            }
        } );


       open.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, WebView.class));
           }
       } );

    }

}
