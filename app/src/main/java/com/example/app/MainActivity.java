package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        private TextView textContent;
        private ImageView imageContent;
        private ProgressBar progressBar;
        private int currentPage = 1;
        Button login;
        Button signup;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textContent = findViewById(R.id.textContent);
            imageContent = findViewById(R.id.imageContent);
            progressBar = findViewById(R.id.progressBar);
            Button btnNext = findViewById(R.id.btnNext);
            login=findViewById(R.id.btnLogin);
            signup=findViewById(R.id.btnSignUp);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, loginpage.class);
                    startActivity(i);

                }
            });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, signuppage.class);
                    startActivity(i);

                }
            });

            btnNext.setOnClickListener(view -> {
                if (currentPage < 3) {
                    currentPage++;
                    updateContent();
                }
            });
        }

        private void updateContent() {
            switch (currentPage) {
                case 1:
                    textContent.setText("Welcome to the GATE Mock Test");
                    imageContent.setImageResource(R.drawable.homeimage); // Change to your image
                    progressBar.setProgress(currentPage);
                    findViewById(R.id.btnSignUp).setVisibility(View.GONE);
                    findViewById(R.id.btnLogin).setVisibility(View.GONE);
                    break;
                case 2:
                    textContent.setText("Prepare for GATE Exam");
                    imageContent.setImageResource(R.drawable.secondimage); // Change to your image
                    progressBar.setProgress(currentPage);
                    findViewById(R.id.btnSignUp).setVisibility(View.GONE);
                    findViewById(R.id.btnLogin).setVisibility(View.GONE);
                    break;
                case 3:
                    textContent.setText("Let's Get Started!");
                    imageContent.setImageResource(R.drawable.thirdimage); // Change to your image
                    progressBar.setProgress(currentPage);
                    break;
            }
            if (currentPage == 3) {
                findViewById(R.id.btnNext).setVisibility(View.GONE);
                findViewById(R.id.btnSignUp).setVisibility(View.VISIBLE);
                findViewById(R.id.btnLogin).setVisibility(View.VISIBLE);
            }
        }
    }







