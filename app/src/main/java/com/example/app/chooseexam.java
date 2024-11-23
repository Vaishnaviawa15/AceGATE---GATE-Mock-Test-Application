package com.example.app;

import static com.example.app.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class chooseexam extends AppCompatActivity {

    // Declaring buttons
    Button paper1Button, paper2Button, paper3Button, paper4Button, paper5Button;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_chooseexam);  // Ensure to use the correct XML layout here

        // Linking buttons with their IDs in XML
        paper1Button = findViewById(R.id.paper1);
        paper2Button = findViewById(R.id.paper2);
        paper3Button = findViewById(R.id.paper3);
        paper4Button = findViewById(R.id.paper4);
        paper5Button = findViewById(R.id.paper5);
        home = findViewById(id.homeIcon);

        // Setting onClickListeners for each button
        paper1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseexam.this, Paper1.class);  // Replace with your actual class name
                startActivity(intent);
            }
        });

        paper2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseexam.this, Paper1.class);  // Replace with your actual class name
                startActivity(intent);
            }
        });

        paper3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseexam.this, Paper1.class);  // Replace with your actual class name
                startActivity(intent);
            }
        });

        paper4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseexam.this, Paper1.class);  // Replace with your actual class name
                startActivity(intent);
            }
        });

        paper5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseexam.this, Paper1.class);  // Replace with your actual class name
                startActivity(intent);
            }
        });

        // Setting the ImageButton for the home icon
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(chooseexam.this, homescreen.class);
                startActivity(i);
            }
        });
    }
}