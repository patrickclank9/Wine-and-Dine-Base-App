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

public class WineSearchActivity3 extends AppCompatActivity {

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

                wines.addWine(new Wine("Vin De Porche","Rose","Pinot Noir",13.1,2017,"Cakebread Cellars",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Pasta");
                                add("Pork");
                                add("Lamb");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/25aLvpT.png");
                        }}));
                wines.addWine(new Wine("Pheonix","Rose","Cabernet Sauvignon",13.8,2017,"Cakebread Cellars",
                        new ArrayList<String>(){
                            {
                                add("Steak");
                                add("Lamb");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/25aLvpT.png");
                        }}));
                wines.addWine(new Wine("Wente Reisling","Rose","Reisling",13.0,2016,"Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("White Sauce Pasta");
                                add("Pork");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/xxparNR.jpg");
                        }}));
                wines.addWine(new Wine("Wente Small Lot Rose","Rose","Pinot Noir",13.1,2017," Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Pasta");
                                add("Pork");
                                add("Lamb");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/xxparNR.jpg");
                        }}));
                wines.addWine(new Wine("Wente Barbera","Rose","Barbera",14.2,2016,"Wente Vineyards",
                        new ArrayList<String>(){
                            {
                                add("Steak");
                                add("Cheese");
                                add("Lamb");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/xxparNR.jpg");
                        }}));
                wines.addWine(new Wine("Vin De Porche","Rose","Pinot Noir",13.1,2017,"Cakebread Cellars",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Pasta");
                                add("Pork");
                                add("Lamb");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/25aLvpT.png");
                        }}));
                wines.addWine(new Wine("Avant-Garde Pinot Noir Rosé","Rose","Pinot Noir",13.0,2017,"Domaine Carneros",
                        new ArrayList<String>(){
                            {
                                add("Chicken");
                                add("Pasta");
                                add("Pork");
                                add("Lamb");
                                add("Turkey");
                            }},
                        new ArrayList<String>(){{
                            add("https://i.imgur.com/Va7wtCK.png");
                        }}));

                adapter = new WineSearchAdapter(wines.getWines());

                adapter.setWineItemClickListener(new WineSearchAdapter.WineItemClickListener() {
                    @Override
                    public void onWineItemClicked(Wine selectedItem) {
                        Intent navIntent = new Intent(WineSearchActivity3.this, WineInfoActivity.class);
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
                startActivity(new Intent(WineSearchActivity3.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity3.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineSearchActivity3.this, MapsActivity.class));
            }
        });

    }
}
