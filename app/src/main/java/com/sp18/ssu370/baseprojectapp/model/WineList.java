package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import Database.WineEntity;
import Database.WineAndDineDatabase;

public class WineList {
    private ArrayList<WineEntity> Wines;

    public ArrayList<WineEntity> getWines() {
        return Wines;
    }

    public void setWines(WineAndDineDatabase data, String Winetype) {
        Wines = new ArrayList<WineEntity>(data.myDao().getWineVarietal(Winetype));
    }
}
