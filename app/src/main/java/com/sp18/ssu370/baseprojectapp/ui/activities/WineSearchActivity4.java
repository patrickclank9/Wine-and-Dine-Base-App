package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sp18.ssu370.baseprojectapp.R;
import com.sp18.ssu370.baseprojectapp.model.Wine;
import com.sp18.ssu370.baseprojectapp.model.WineList;
import com.sp18.ssu370.baseprojectapp.network.BaseAsyncTask;
import com.sp18.ssu370.baseprojectapp.search.WineSearchAdapter;
import com.sp18.ssu370.baseprojectapp.search.WineSearchAdapter;

import java.util.ArrayList;

public class WineSearchActivity4 extends AppCompatActivity {

    private Button wineinfobutton;
    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;
    private EditText searchEditText;
    private Button searchButton;
    private BaseAsyncTask task;
    private LinearLayoutManager linearLayoutManager;
    private WineSearchAdapter adapter;
    private RecyclerView wineResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_search);

        searchEditText = (EditText)findViewById(R.id.wine_search_edit_text);
        searchButton = (Button)findViewById(R.id.wine_search_button);
        wineResultList = (RecyclerView)findViewById(R.id.wine_result_list);
        linearLayoutManager = new LinearLayoutManager(this);

        wineResultList.setLayoutManager(linearLayoutManager);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WineList Wines = new WineList();

                Wines.addWine(new Wine("cheese wine4", "Wine info", "5156", new ArrayList<String>(){{
                    add("crackers");
                    add("peanut butter");
                }}, new ArrayList<String>(){{
                    add("http://www.howmuchisin.com/produce_converters_app/vegetables_large/cheese.png");
                }}));

                Wines.addWine(new Wine("egg wine4", "Wine info", "5156", new ArrayList<String>(){{
                    add("crackers");
                    add("peanut butter");
                }}, new ArrayList<String>(){{
                    add("http://fedandfit.com/wp-content/uploads/2018/01/Hard-Boiled-Egg-200x200.jpg");
                }}));

                adapter = new WineSearchAdapter(Wines.getWines());

                adapter.setWineItemClickListener(new WineSearchAdapter.WineItemClickListener() {
                    @Override
                    public void onWineItemClicked(Wine selectedItem) {
                        Intent navIntent = new Intent(WineSearchActivity4.this, WineInfoActivity.class);
                        //navIntent.putExtra(WineInfoActivity.Wine_EXTRA_KEY, Parcels.wrap(selectedItem));
                        startActivity(navIntent);
                    }
                });
                wineResultList.setAdapter(adapter);
            }
        });

        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity4.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity4.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity4.this, MapsActivity.class));
            }
        });

    }
}
