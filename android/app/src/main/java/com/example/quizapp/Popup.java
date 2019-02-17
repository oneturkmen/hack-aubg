package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Popup extends AppCompatActivity {

    List<Question> questions;
    Random randomGenerator;

    TextView my_question;
    Button correct_answer;
    Button answer2;
    Button answer3;
    Button answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        // Set qs
//        questions = new ArrayList<Question>();
//        questions.add(
//                new Question(1,
//                        "The interval of 2 seconds between the drivers is ok when",
//                "The road is dry.", "The road is wet.",
//                "The visibility is reduced due to fog.",
//                        "The visibility is limited."));

        // Get random question first
        // Question question_to_set = this.getRandomQuestion();

        my_question = (TextView) findViewById(R.id.questPlace);
        correct_answer = (Button) findViewById(R.id.ansA);
        answer2 = (Button) findViewById(R.id.ansB);
        answer3 = (Button) findViewById(R.id.ansC);
        answer4 = (Button) findViewById(R.id.ansD);

        my_question.setText("The interval of 2 seconds between the drivers is ok when");
        correct_answer.setText("The road is dry.");
        answer2.setText("The road is wet.");
        answer3.setText("The visibility is limited.");
        answer4.setText("The visibility is limited.");
    }


}
