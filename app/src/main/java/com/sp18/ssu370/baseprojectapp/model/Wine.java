package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Wine {

    private String winename;
    private String winecolor;
    private String winevarietal;
    private Double wineABV;
    private Integer wineyear;
    private String winery;

    public String getWinery() {
        return winery;
    }

    private ArrayList<String> complements;
    private ArrayList<String> thumbnailSources;

    public Wine(String winename, String winecolor, String winevarietal, Double wineABV, Integer wineyear,String winery, ArrayList<String> complements, ArrayList<String> thumbnailSources) {
        this.winename = winename;
        this.winecolor = winecolor;
        this.winevarietal = winevarietal;
        this.wineABV = wineABV;
        this.wineyear = wineyear;
        this.winery=winery;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

    public String getComplementsString() {
        String listString = "\n";
        for (String s : complements) {
            listString += s + "\n";
        }
        return listString;
    }

    public String getName() {
        return winename;
    }

    public String getWinecolor() {
        return winecolor;
    }

    public String getWinevarietal() {
        return winevarietal;
    }

    public Double getWineABV() {
        return wineABV;
    }

    public Integer getWineyear() {
        return wineyear;
    }

    public ArrayList<String> getComplements() {
        return complements;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}

