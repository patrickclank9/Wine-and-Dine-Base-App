package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import Database.FoodEntity;
import Database.WineAndDineDatabase;

public class FoodList {
    private ArrayList<FoodEntity> Foods;

    public ArrayList<FoodEntity> getFoods() {
        return Foods;
    }

    public void setFoods(WineAndDineDatabase data, String foodtype) {
        Foods = new ArrayList<FoodEntity>(data.myDao().getFoodType(foodtype));
    }
}
