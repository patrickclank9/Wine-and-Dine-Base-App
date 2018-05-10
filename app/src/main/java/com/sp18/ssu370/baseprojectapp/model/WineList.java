package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WineList {
    private ArrayList<Wine> Wines = new ArrayList<Wine>();

    public void addWine(Wine wine){
        Wines.add(wine);
    }

    public ArrayList<Wine> getWines(){
        return Wines;
    }
}
