package com.example.quizapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class FilePickerActivity extends AppCompatActivity {

    TextView filePathShow;
    Button btnFilePicker;
    Intent filePathIntent;
    List<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_picker);

        filePathShow = (TextView) findViewById(R.id.txt_filePicker);
        btnFilePicker = (Button) findViewById(R.id.btn_filePicker);

        btnFilePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filePathIntent = new Intent(Intent.ACTION_GET_CONTENT);
                filePathIntent.setType("*/*");
                startActivityForResult(filePathIntent, 10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 10: {
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    filePathShow.setText(path);
                    try {
                        questions = XmlParser.parse(path);

                        for (Question question : questions) {
                            question.getAllInfo();
                            System.out.println();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                break;
            }
        }
    }

    public String getFilePathString() {
        return this.filePathShow.getText().toString();
    }
}
