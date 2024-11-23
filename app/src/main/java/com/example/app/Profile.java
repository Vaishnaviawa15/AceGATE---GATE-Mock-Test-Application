package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileOutputStream;
import java.io.IOException;

public class Profile extends AppCompatActivity {
    ImageButton home;
    ImageButton exam;
    ImageButton result;
    ImageButton profile;
    Button myTestsButton;
    Button analysisButton;
    Button submitReviewButton;
    Button taketest;
    Button viewresult;
    EditText reviewInput;
    RatingBar ratingBar;
    LinearLayout myTestsLayout, testAnalysisLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        home=findViewById(R.id.homeIcon);
        exam=findViewById(R.id.examIcon);
        result=findViewById(R.id.resultIcon);
        profile=findViewById(R.id.profileIcon);

        myTestsButton = findViewById(R.id.myTestsButton);
        analysisButton = findViewById(R.id.analysisButton);
        myTestsLayout = findViewById(R.id.myTestsLayout);
        testAnalysisLayout = findViewById(R.id.testAnalysisLayout);
        taketest=findViewById(R.id.giveTestButton);
        viewresult=findViewById(R.id.viewResult);

        showMyTestsLayout();

        myTestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyTestsLayout();
            }
        });
        analysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTestAnalysisLayout();
            }
        });

        reviewInput = findViewById(R.id.reviewInput);
        ratingBar = findViewById(R.id.ratingBar);
        submitReviewButton = findViewById(R.id.submitReviewButton);

        submitReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReview();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, homescreen.class);
                startActivity(i);
            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, Exam.class);
                startActivity(i);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, Result.class);
                startActivity(i);
            }
        });
    }
    private void showMyTestsLayout() {
        myTestsLayout.setVisibility(View.VISIBLE);
        testAnalysisLayout.setVisibility(View.GONE);

        taketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(Profile.this, Exam.class);
                startActivity(i2);
            }
        });
    }

    private void showTestAnalysisLayout() {
        testAnalysisLayout.setVisibility(View.VISIBLE);
        myTestsLayout.setVisibility(View.GONE);

        viewresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, Result.class);
                startActivity(i);
            }
        });
    }

    private void saveReview() {
        String review = reviewInput.getText().toString();
        float rating = ratingBar.getRating();
        String reviewText = "Rating: " + rating + "\nReview: " + review + "\n";

        try (FileOutputStream fos = openFileOutput("reviews.txt", MODE_APPEND)) {
            fos.write(reviewText.getBytes());
            Toast.makeText(this, "Review submitted!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to submit review.", Toast.LENGTH_SHORT).show();
        }
    }
}


