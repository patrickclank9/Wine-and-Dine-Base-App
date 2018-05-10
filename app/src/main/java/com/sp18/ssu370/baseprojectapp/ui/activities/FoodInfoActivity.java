package com.sp18.ssu370.baseprojectapp.ui.activities;

import Database.StoreEntity;
import Database.WineAndDineDao;
import Database.WineAndDineDatabase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;
import com.sp18.ssu370.baseprojectapp.search.WineSearchAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import Database.FoodEntity;

public class FoodInfoActivity extends AppCompatActivity {

    public static final String FOOD_EXTRA_KEY = "foodExtraKey";
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;
    int storeId = 2;
    WineAndDineDatabase w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

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

                // startActivity(new Intent(FoodInfoActivity.this, MapsActivity.class));
                //openGMaps(Address);
            }
        });

    }


    public void openGMaps(String address){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + address));
        startActivity(intent);
    }

}
