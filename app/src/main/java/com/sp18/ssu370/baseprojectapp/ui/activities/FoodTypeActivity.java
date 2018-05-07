package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;

public class FoodTypeActivity extends AppCompatActivity {

    private ImageButton foodsearchbutton1;
    private ImageButton foodsearchbutton2;
    private ImageButton foodsearchbutton3;
    private ImageButton foodsearchbutton4;
    private ImageButton foodsearchbutton5;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_type);

        foodsearchbutton1 = findViewById(R.id.toFoodSearchActivity1);                                   // Wine Search button  Breakfast
        foodsearchbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, FoodSearchActivity.class));
            }
        });

        foodsearchbutton2 = findViewById(R.id.toFoodSearchActivity2);                                   // Wine Search button  Lunch
        foodsearchbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, FoodSearchActivity.class));
            }
        });

        foodsearchbutton3 = findViewById(R.id.toFoodSearchActivity3);                                   // Wine Search button  Dinner
        foodsearchbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, FoodSearchActivity.class));
            }
        });

        foodsearchbutton4 = findViewById(R.id.toFoodSearchActivity4);                                   // Wine Search button  Dessert
        foodsearchbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, FoodSearchActivity.class));
            }
        });

        foodsearchbutton5 = findViewById(R.id.toFoodSearchActivity5);                                   // Wine Search button  Snack
        foodsearchbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, FoodSearchActivity.class));
            }
        });

        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodTypeActivity.this, MapsActivity.class));
            }
        });

    }
}
