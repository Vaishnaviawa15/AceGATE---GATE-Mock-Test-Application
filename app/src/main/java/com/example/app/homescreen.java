package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class homescreen extends AppCompatActivity {

    ImageButton menu;
    ImageButton home;
    ImageButton exam;
    ImageButton result;
    ImageButton profile;
    Button test;
    TextView content;
    ImageView banner;
    DrawerLayout drawerLayout;
    ListView drawerList;
    String[] drawerItems;
    Button givetest;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        givetest=findViewById(R.id.Test);
        givetest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(homescreen.this, Exam.class);
                startActivity(i);
            }
        });

        menu=findViewById(R.id.Menu);

        content=findViewById(R.id.tv1);
        banner=findViewById(R.id.banner);

        home=findViewById(R.id.homeIcon);
        exam=findViewById(R.id.examIcon);
        profile=findViewById(R.id.profileIcon);
        result=findViewById(R.id.resultIcon);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);


        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homescreen.this, Exam.class);
                startActivity(i);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homescreen.this, Result.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homescreen.this, Profile.class);
                startActivity(i);
            }
        });





        // List items for the drawer
        drawerItems = new String[] {
                "Practice Reminder",
                "My Saved List",
                "Message",
                "Profile",
                "Logout"
        };

        // Set adapter for ListView
        drawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, drawerItems));

        // Handle list item clicks
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = drawerItems[position];
                Toast.makeText(homescreen.this, selectedItem + " clicked", Toast.LENGTH_SHORT).show();

                // Close drawer after item is clicked
                drawerLayout.closeDrawers();
            }
        });

        // Handle Menu button click
        ImageButton menuButton = findViewById(R.id.Menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the drawer when Menu button is clicked
                drawerLayout.openDrawer(drawerList);
            }
        });

        // Close drawer when clicking outside
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // Close the drawer if user clicks outside
                if (slideOffset == 0 && drawerLayout.isDrawerVisible(drawerView)) {
                    drawerLayout.closeDrawer(drawerView);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Close drawer if it's open, otherwise handle back press normally
        if (drawerLayout.isDrawerOpen(drawerList)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}