package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Paper1 extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private Button submitButton;

    // Correct answers
    private String[] correctAnswers = {
            "All of the above",
            "AVL tree",
            "O(1)",
            "Stack",
            "Inorder",
            "Merge Sort",
            "O(n^2)",
            "Stack"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper1);

        dbHelper = new DatabaseHelper(this);
        submitButton = findViewById(R.id.submit_button);
        dbHelper.clearAnswers();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitTest();
            }
        });
    }

    private void submitTest() {
        boolean allSubmitted = true;
        int score = 0; // Initialize score

        for (int i = 0; i < correctAnswers.length; i++) {
            RadioGroup optionsGroup = findViewById(getResources().getIdentifier("options" + (i + 1), "id", getPackageName()));
            int selectedId = optionsGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Please answer all questions.", Toast.LENGTH_SHORT).show();
                allSubmitted = false;
                break;
            }

            RadioButton selectedOption = findViewById(selectedId);
            String answer = selectedOption.getText().toString();

            // Insert the answer into the database
            if (!dbHelper.insertAnswer("Question " + (i + 1), answer)) {
                Toast.makeText(this, "Submission failed for Question " + (i + 1), Toast.LENGTH_SHORT).show();
                allSubmitted = false;
                break;
            }

            // Check if the answer is correct
            if (answer.equalsIgnoreCase(correctAnswers[i])) {
                score++; // Increment score for correct answer
            }
        }

        if (allSubmitted) {
            Toast.makeText(this, "Test submitted successfully!", Toast.LENGTH_SHORT).show();

            // Start the answers activity to show the answers
            Intent intent = new Intent(Paper1.this, answers.class);
            intent.putExtra("SCORE", score); // Pass the score to the answers activity
            intent.putExtra("TOTAL_QUESTIONS", correctAnswers.length); // Pass total questions
            startActivity(intent);
            finish(); // Optionally, call finish() to close the Question activity
        }
    }

}

