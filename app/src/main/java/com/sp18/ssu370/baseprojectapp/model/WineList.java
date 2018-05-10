package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WineList {
    private ArrayList<Wine> Wines = new ArrayList<Wine>();

    public void addWine(Wine food){
        Wines.add(food);
    }

    public void setWines(ArrayList<Wine> f){
        this.Wines = f;
    }

    public ArrayList<Wine> getWines() {
        return Wines;
    }
}