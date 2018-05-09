package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

public class Wine {
    private String winename;

    private String source;

    private String WineId;

    private ArrayList<String> complements;

    private ArrayList<String> thumbnailSources;

    public Wine(String foodname, String source, String FoodId, ArrayList<String> complements, ArrayList<String> thumbnailSources){
        this.winename = foodname;
        this.source = source;
        this.WineId = FoodId;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

    public String getName() {
        return winename;
    }

    public String getSource() {
        return source;
    }

    public String getWineId() {
        return WineId;
    }

    public ArrayList<String> getComplements() {
        return complements;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
