package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.sp18.ssu370.baseprojectapp.ui.activities.FoodInfoActivity;

import org.parceler.Parcel;

import java.util.ArrayList;

import Database.FoodEntity;

public class Food {
    private String foodname;

    private String source;

    private String FoodId;

    private ArrayList<String> complements;

    private ArrayList<String> thumbnailSources;

    public Food(String foodname, String source, String FoodId, ArrayList<String> complements, ArrayList<String> thumbnailSources){
        this.foodname = foodname;
        this.source = source;
        this.FoodId = FoodId;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

    public String getName() {
        return foodname;
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

    public String getComplementsString() {
        String listString = "";
        for (String s : complements) {
            listString += s + "\n";
        }
        return listString;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
