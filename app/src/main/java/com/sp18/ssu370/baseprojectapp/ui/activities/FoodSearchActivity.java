package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;
import com.sp18.ssu370.baseprojectapp.model.Food;
import com.sp18.ssu370.baseprojectapp.model.FoodList;
import com.sp18.ssu370.baseprojectapp.network.FoodSearchAsyncTask;
import com.sp18.ssu370.baseprojectapp.search.FoodSearchAdapter;

import org.parceler.Parcels;

public class FoodSearchActivity extends AppCompatActivity {

    private Button foodinfobutton;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;
    private EditText searchEditText;
    private Button searchButton;
    private FoodSearchAsyncTask task;
    private LinearLayoutManager linearLayoutManager;
    private FoodSearchAdapter adapter;
    private RecyclerView foodResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        /*foodinfobutton = findViewById(R.id.toFoodInfoActivity);                                   // Food Search button  Red
        foodinfobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodSearchActivity.this, FoodInfoActivity.class));
            }
        });*/

        searchEditText = (EditText)findViewById(R.id.food_search_edit_text);
        searchButton = (Button)findViewById(R.id.food_search_button);
        foodResultList = (RecyclerView)findViewById(R.id.food_result_list);
        linearLayoutManager = new LinearLayoutManager(this);

        foodResultList.setLayoutManager(linearLayoutManager);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*task = new FoodSearchAsyncTask();
                task.setCallbackListener(new FoodSearchAsyncTask.OnFoodFetchResponse() {
                    @Override
                    public void onCallback(FoodList FoodList) {
                        adapter = new FoodSearchAdapter(FoodList.getFoods());

                        adapter.setFoodItemClickListener(new FoodSearchAdapter.FoodItemClickListener() {
                            @Override
                            public void onFoodItemClicked(Food selectedItem) {
                                Intent navIntent = new Intent(FoodSearchActivity.this, FoodInfoActivity.class);
                                navIntent.putExtra(FoodInfoActivity.FOOD_EXTRA_KEY, Parcels.wrap(selectedItem));
                                startActivity(navIntent);
                            }
                        });

                        foodResultList.setAdapter(adapter);
                    }
                });

                String searchTerms = searchEditText.getText().toString();
                task.execute(searchTerms);*/
                adapter = new FoodSearchAdapter(new FoodList().getFoods());

                adapter.setFoodItemClickListener(new FoodSearchAdapter.FoodItemClickListener() {
                    @Override
                    public void onFoodItemClicked(Food selectedItem) {
                        Intent navIntent = new Intent(FoodSearchActivity.this, FoodInfoActivity.class);
                        //navIntent.putExtra(FoodInfoActivity.FOOD_EXTRA_KEY, Parcels.wrap(selectedItem));
                        startActivity(navIntent);
                    }
                });
                foodResultList.setAdapter(adapter);
            }
        });

        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodSearchActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodSearchActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodSearchActivity.this, MapsActivity.class));
            }
        });

    }
}
