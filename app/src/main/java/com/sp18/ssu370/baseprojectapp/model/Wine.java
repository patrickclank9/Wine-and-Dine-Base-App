package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

public class Wine {
    private String name;

    private String source;

    private String WineId;

    private ArrayList<String> complements;

    private ArrayList<String> thumbnailSources;

    public String getName() {
        return name;
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
