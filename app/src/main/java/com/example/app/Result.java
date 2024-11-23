package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
    ImageButton home;
    ImageButton exam;
    ImageButton result;
    ImageButton profile;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        home=findViewById(R.id.homeIcon);
        exam=findViewById(R.id.examIcon);
        result=findViewById(R.id.resultIcon);
        profile=findViewById(R.id.profileIcon);


        // Get the score and total questions from the intent
        int score = getIntent().getIntExtra("SCORE", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 8); // Get total questions

        // Display the score
        TextView scoreTextView = findViewById(R.id.score_textview);
        scoreTextView.setText("Your score is: " + score + "/" + totalQuestions);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this, homescreen.class);
                startActivity(i);
            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this, Exam.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this, Profile.class);
                startActivity(i);
            }
        });

    }

}