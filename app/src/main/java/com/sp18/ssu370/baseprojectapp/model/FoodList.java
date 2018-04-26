package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FoodList {
    //@SerializedName("matches")
    private ArrayList<Food> Foods = new ArrayList<Food>(){{
        for (int i = 0; i < 30; i++) {
            add(new Food());
        }
    }};

    public ArrayList<Food> getFoods() {
        return Foods;
    }
}
