package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WineList {
    @SerializedName("matches")
    private ArrayList<Wine> Wines;

    public ArrayList<Wine> getWines() {
        return Wines;
    }
}
