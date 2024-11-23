package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signuppage extends AppCompatActivity {
    Button finalsignup;
    EditText fn;
    EditText ln;
    EditText pass;
    EditText repass;
    EditText usern;
    EditText emai;
    DatabaseHelper dbHelper; // Declare DatabaseHelper

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        fn = findViewById(R.id.firstname);
        ln = findViewById(R.id.lastname);
        pass = findViewById(R.id.Password1);
        repass = findViewById(R.id.Retypepass);
        usern = findViewById(R.id.username);
        emai = findViewById(R.id.email);

        dbHelper = new DatabaseHelper(this); // Initialize DatabaseHelper

        finalsignup = findViewById(R.id.signup);
        finalsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String firstname = fn.getText().toString();
                String lastname = ln.getText().toString();
                String username = usern.getText().toString();
                String email = emai.getText().toString();
                String password = pass.getText().toString();
                String confirmPassword = repass.getText().toString();

                // Validate input
                if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signuppage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(signuppage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert user data into the database
                if (dbHelper.insertUser(firstname, lastname, username, email, password)) {
                    Toast.makeText(signuppage.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(signuppage.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(signuppage.this, settinguppage.class);
                startActivity(i);
            }
        });
    }
}