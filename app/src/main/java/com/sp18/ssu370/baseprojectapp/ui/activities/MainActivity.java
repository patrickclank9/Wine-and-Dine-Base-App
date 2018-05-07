
package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    private WineAndDineDatabase winedatabase;


    private Button locationbutton;
    private Button winetypebutton;
    private Button foodtypebutton;
    private Button profilebutton;
    private Button mainactivitybutton;
    private Button mapbutton;

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


                String json = readJson(R.raw.mock_data);
                Gson gson = new Gson();

                MockDataContainer mockDataList = gson.fromJson(json, MockDataContainer.class);

                for (WineEntity wine : mockDataList.getWines()) {  // for each entry in list
                    winedatabase.myDao () . insertWine ( wine );
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
                for (AddressEntity address : mockDataList.getAddress()) {
                    winedatabase.myDao().insertAddress(address);
                }
            }
        }) .start();




        winetypebutton = (Button) findViewById(R.id.toWineTypeActivity);                                        // Wine Type button
        winetypebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WineTypeActivity.class));

            }
        });

        foodtypebutton = (Button) findViewById(R.id.toFoodTypeActivity);                                        // Wine Type button
        foodtypebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoodTypeActivity.class));
            }
        });

        profilebutton = (Button) findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = (Button) findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        mapbutton = (Button) findViewById(R.id.FindLoc);                                                       // Map button
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
