package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;

public class WineTypeActivity extends AppCompatActivity {

    private ImageButton winesearchbutton1;
    private ImageButton winesearchbutton2;
    private ImageButton winesearchbutton3;
    private ImageButton winesearchbutton4;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_type);

        winesearchbutton1 = findViewById(R.id.toWineSearchActivity1);                                   // Wine Search button  Red
        winesearchbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, WineSearchActivity.class));
            }
        });

        winesearchbutton2 = findViewById(R.id.toWineSearchActivity2);                                   // Wine Search button  White
        winesearchbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, WineSearchActivity2.class));
            }
        });

        winesearchbutton3 = findViewById(R.id.toWineSearchActivity3);                                   // Wine Search button  Rosea
        winesearchbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, WineSearchActivity3.class));
            }
        });


        winesearchbutton4 = findViewById(R.id.toWineSearchActivity4);                                   // Wine Search button  Sparkling
        winesearchbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, WineSearchActivity4.class));
            }
        });






        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, MapsActivity.class));
            }
        });

    }
}
