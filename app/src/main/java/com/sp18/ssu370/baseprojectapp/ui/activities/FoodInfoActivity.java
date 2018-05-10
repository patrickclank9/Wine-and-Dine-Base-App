package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sp18.ssu370.baseprojectapp.R;

import org.w3c.dom.Text;

public class FoodInfoActivity extends AppCompatActivity {

    public static final String FOOD_TITLE = "foodExtraKey";
    public static final String IMAGE_URL = "foodURL";
    public static final String MEAL_TYPE = "mealType";
    public static final String COMPLEMENTS = "complements";
    public static final String MEAL_DESIGNATION = "meald";
    public static final String ADDRESS = "address";

    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;
    private TextView foodname;
    private TextView mealDesignation;
    private TextView mealType;
    private TextView complements;
    private ImageView thumbnailSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        Bundle b = getIntent().getExtras();

        foodname = findViewById(R.id.food_name);
        thumbnailSource = findViewById(R.id.food_pic);
        

        if(b!=null) {
            foodname.setText((String)b.get(FOOD_TITLE));
            Glide.with(this)
                    .load(b.get(IMAGE_URL))
                    .into(thumbnailSource);
        }


        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodInfoActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodInfoActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodInfoActivity.this, MapsActivity.class));
            }
        });

    }
}
