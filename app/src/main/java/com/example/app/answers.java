package com.example.app;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class answers extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private LinearLayout answersLayout;
    private int score; // Store the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        dbHelper = new DatabaseHelper(this);
        answersLayout = findViewById(R.id.answers_layout);

        // Get the score from the intent
        score = getIntent().getIntExtra("SCORE", 0);

        displayAnswers();

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ScoreDisplayActivity to show the score
                Intent intent = new Intent(answers.this, Result.class);
                intent.putExtra("SCORE", score); // Pass the score to the new activity
                startActivity(intent);
                finish(); // Optionally, call finish() to close the answers activity
            }
        });
    }

    private void displayAnswers() {
        // Query the database for answers
        Cursor cursor = dbHelper.getAllAnswers();

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                String question = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_QUESTION));
                @SuppressLint("Range")
                String answer = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ANSWER));

                // Create a TextView for each answer
                TextView answerView = new TextView(this);
                answerView.setText(question + ": " + answer);
                answersLayout.addView(answerView);
            } while (((Cursor) cursor).moveToNext());
        }

        cursor.close();
    }
}