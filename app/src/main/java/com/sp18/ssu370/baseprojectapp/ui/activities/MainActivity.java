package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton winetypebutton;
    private ImageButton foodtypebutton;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winetypebutton = findViewById(R.id.toWineTypeActivity);                                        // Wine Type button
        winetypebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WineTypeActivity.class));

            }
        });

        foodtypebutton = findViewById(R.id.toFoodTypeActivity);                                        // Wine Type button
        foodtypebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoodTypeActivity.class));
            }
        });

        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });



    }


}
