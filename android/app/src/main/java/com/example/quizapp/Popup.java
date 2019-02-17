package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class Popup extends AppCompatActivity {

    static List<Question> questions;
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

        // Get random question first
        Question question_to_set = this.getRandomQuestion();

        my_question = (TextView) findViewById(R.id.questPlace);
        correct_answer = (Button) findViewById(R.id.ansA);
        answer2 = (Button) findViewById(R.id.ansB);
        answer3 = (Button) findViewById(R.id.ansC);
        answer4 = (Button) findViewById(R.id.ansD);

        my_question.setText(question_to_set.getQuestion());
        correct_answer.setText(question_to_set.getCorrectAnswer());
        answer2.setText(question_to_set.getAnswer2());
        answer3.setText(question_to_set.getAnswer3());
        answer4.setText(question_to_set.getAnswer4());
    }

    private Question getRandomQuestion() {
        // Returns random question
        int index = randomGenerator.nextInt(questions.size());
        Question question = questions.get(index);

        return question;
    }

    public static void setQuestions(List<Question> _questions) {
        questions = _questions;
    }


}
