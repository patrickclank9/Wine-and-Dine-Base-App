package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Food {
    @SerializedName("recipeName")
    private String name;

    @SerializedName("sourceDisplayName")
    private String source;

    @SerializedName("id")
    private String FoodId;

    @SerializedName("ingredients")
    private ArrayList<String> complements;

    @SerializedName("smallImageUrls")
    private ArrayList<String> thumbnailSources;

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
