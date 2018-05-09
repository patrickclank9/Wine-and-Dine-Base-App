package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.sp18.ssu370.baseprojectapp.ui.activities.FoodInfoActivity;

import org.parceler.Parcel;

import java.util.ArrayList;

import Database.FoodEntity;

public class Food {
    private String name;

    private String source;

    private String FoodId;

    private ArrayList<String> complements;

    private ArrayList<String> thumbnailSources;

    public Food(String name, String source, String FoodId, ArrayList<String> complements, ArrayList<String> thumbnailSources){
        this.name = name;
        this.source = source;
        this.FoodId = FoodId;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getFoodId() {
        return FoodId;
    }

    public ArrayList<String> getComplements() {
        return complements;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
