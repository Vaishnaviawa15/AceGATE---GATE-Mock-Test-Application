package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exam extends AppCompatActivity {
    ImageButton home;
    ImageButton exam;
    ImageButton result;
    ImageButton profile;
    Button start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        start=findViewById(R.id.starttest);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Exam.this, chooseexam.class);
                startActivity(i);
            }
        });

        home=findViewById(R.id.homeIcon);
        exam=findViewById(R.id.examIcon);
        result=findViewById(R.id.resultIcon);
        profile=findViewById(R.id.profileIcon);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Exam.this, homescreen.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Exam.this, Profile.class);
                startActivity(i);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Exam.this, Result.class);
                startActivity(i);
            }
        });


    }
}