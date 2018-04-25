package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FoodList {
    //@SerializedName("matches")
    private ArrayList<Food> Foods = new ArrayList<Food>();

    public ArrayList<Food> getFoods() {
        Foods.add(new Food());
        Foods.add(new Food());
        return Foods;
    }
}
