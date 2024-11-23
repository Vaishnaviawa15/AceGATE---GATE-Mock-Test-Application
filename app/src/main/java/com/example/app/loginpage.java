package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginpage extends AppCompatActivity {
    Button proceed;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        // Initialize the views
        proceed = findViewById(R.id.proceed);
        editTextEmail = findViewById(R.id.username); // Assuming the email EditText has this ID
        editTextPassword = findViewById(R.id.password); // Assuming the password EditText has this ID

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the validation method when the user clicks the proceed button
                if (validateForm()) {
                    // Proceed to the next activity if validation passes
                    Intent i = new Intent(loginpage.this, settinguppage.class);
                    startActivity(i);
                } else {
                    // Show a message if validation fails
                    Toast.makeText(loginpage.this, "Please fill out the fields correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate the email and password fields
    private boolean validateForm() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Check if email or password fields are empty
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return false;
        }

        // Validate email format using Android's built-in Patterns class
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }

        // Add any additional checks here (e.g., minimum password length, specific character requirements)
        if (password.length() < 6) {
            return false;  // Example: Check if password is less than 6 characters
        }

        return true; // Return true if all validations pass
    }
}
