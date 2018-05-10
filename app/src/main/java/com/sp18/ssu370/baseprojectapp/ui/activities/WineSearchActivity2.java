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

public class WineSearchActivity2 extends AppCompatActivity {

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
                WineList wines = new WineList();

                wines.addWine(new Wine("Jewel Collection","White","Chardonnay",14.4,2015,"Ruby Hill",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Fish");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/8NKPjEl.jpg");
                        }}));
                wines.addWine(new Wine("Ruby Hill Chardonnay","White","Chardonnay",14.1,2016,"Ruby Hill",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Fish");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/8NKPjEl.jpg");
                        }}));
                wines.addWine(new Wine("Cakebread Chardonnay","White","Chardonnay",14.3,2015,"Cakebread Cellars",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Fish");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/5VSW8PL.png");
                        }}));
                wines.addWine(new Wine("Eric's Chardonnay","White","Chardonnay",13.5,2017,"Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Fish");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/nVwH5Xw.jpg");
                        }}));
                wines.addWine(new Wine("Riva Ranch Chardonnay","White","Chardonnay",14.5,2016,"Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Fish");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/nVwH5Xw.jpg");
                        }}));

                adapter = new WineSearchAdapter(wines.getWines());

                adapter.setWineItemClickListener(new WineSearchAdapter.WineItemClickListener() {
                    @Override
                    public void onWineItemClicked(Wine selectedItem) {
                        Intent navIntent = new Intent(WineSearchActivity2.this, WineInfoActivity.class);
                        navIntent.putExtra(WineInfoActivity.WINE_TITLE, selectedItem.getName());
                        navIntent.putExtra(WineInfoActivity.IMAGE_URL, selectedItem.getThumbnailSources().get(0));
                        navIntent.putExtra(WineInfoActivity.COMPLEMENTS, selectedItem.getComplementsString());
                        navIntent.putExtra(WineInfoActivity.WINERY, selectedItem.getWinery());
                        navIntent.putExtra(WineInfoActivity.WINECOLOR, selectedItem.getWinecolor());
                        navIntent.putExtra(WineInfoActivity.WINEVARIETAL, selectedItem.getWinevarietal());
                        navIntent.putExtra(WineInfoActivity.WINEABV, selectedItem.getWineABV());
                        navIntent.putExtra(WineInfoActivity.WINEYEAR, selectedItem.getWineyear());
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
                startActivity(new Intent(WineSearchActivity2.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity2.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity2.this, MapsActivity.class));
            }
        });

    }
}
