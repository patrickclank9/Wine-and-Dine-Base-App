
package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.sp18.ssu370.baseprojectapp.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import Database.AddressEntity;
import Database.FoodEntity;
import Database.StoreEntity;
import Database.WineAndDineDatabase;
import Database.WineEntity;
import Database.MockDataContainer;
import Database.WineryEntity;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME ="wine_db";
    public  static WineAndDineDatabase winedatabase;
    private ImageButton winetypebutton;
    private ImageButton foodtypebutton;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winedatabase = Room.databaseBuilder(getApplicationContext(),
                WineAndDineDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();



        new Thread(new Runnable() {
            @Override
            public void run() {

                winedatabase.myDao().nukewinery();
                winedatabase.myDao().nukestore();

                String json = readJson(R.raw.mock_data);
                Gson gson = new Gson();

                MockDataContainer mockDataList = gson.fromJson(json, MockDataContainer.class);

                for (WineEntity wine : mockDataList.getWines()) {  // for each entry in list
                    winedatabase.myDao().insertWine ( wine );
                }
                for (FoodEntity food : mockDataList.getFoods()) {
                    winedatabase.myDao().insertFood(food);
                }
                for (WineryEntity winery : mockDataList.getWinery()) {
                    winedatabase.myDao().insertWinery(winery);
                }
                for (StoreEntity store : mockDataList.getStore()) {
                    winedatabase.myDao().insertStore(store);
                }
            }
        }) .start();

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

    private String readJson(int resourceID)
    {
        InputStream ins = getResources().openRawResource(resourceID);
        String json="";
        try{
            String line;
            StringBuilder stringBuffer = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
            if(ins != null){
                while ((line = bufferedReader.readLine()) != null){
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
            }
            json = stringBuffer.toString();
            ins.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return json;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case 1: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startActivity(new Intent(MainActivity.this, MapsActivity.class));
                }else {
                    //permission denied, disable functionality that depends on this permission
                }
            }
        }
    }
}
