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
                WineList wines = new WineList();

                wines.addWine(new Wine("Ruby Sparkling Wine","Sparkling"," Chardonnay",11.0,2017,"Ruby Hill",
                        new ArrayList<String>(){
                            {
                                add("Momosa's");
                                add("Prime Rib");
                                add("Pancakes");
                                add("Eggs");
                                add("Waffles");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/v4RT7Dp.jpg");
                        }}));
                wines.addWine(new Wine("Wente Brut","Sparkling"," Brut",12.5,2015,"Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Prime Rib");
                                add("Pancakes");
                                add("Eggs");
                                add("Waffles");
                                add("Momosa's");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/szvy4nJ.jpg");
                        }}));
                wines.addWine(new Wine("Le Rêve Blanc de Blancs","Sparkling"," Chardonnay",12.1,2011,"Domaine Carneros",
                        new ArrayList<String>(){
                            {
                                add("Momosa's");
                                add("Prime Rib");
                                add("Pancakes");
                                add("Eggs");
                                add("Waffles");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/rZiSmAq.jpg");
                        }}));
                wines.addWine(new Wine("Estate Brut Cuvée","Sparkling"," Chardonnay",12.1,2012,"Domaine Carneros",
                        new ArrayList<String>(){
                            {
                                add("Momosa's");
                                add("Prime Rib");
                                add("Pancakes");
                                add("Eggs");
                                add("Waffles");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/rZiSmAq.jpg");
                        }}));
                wines.addWine(new Wine("Vermeil-Demi-Sec","Sparkling"," Brut",12.0,2013,"Domaine Carneros",
                        new ArrayList<String>(){
                            {
                                add("Momosa's");
                                add("Prime Rib");
                                add("Pancakes");
                                add("Eggs");
                                add("Waffles");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/rZiSmAq.jpg");
                        }}));

                adapter = new WineSearchAdapter(wines.getWines());

                adapter.setWineItemClickListener(new WineSearchAdapter.WineItemClickListener() {
                    @Override
                    public void onWineItemClicked(Wine selectedItem) {
                        Intent navIntent = new Intent(WineSearchActivity4.this, WineInfoActivity.class);
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
