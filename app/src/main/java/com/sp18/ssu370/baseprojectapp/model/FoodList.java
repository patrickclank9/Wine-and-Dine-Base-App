package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import Database.WineAndDineDatabase;

public class FoodList {
    private ArrayList<Food> Foods = new ArrayList<Food>();

    public void addFood(Food food){
        Foods.add(food);
    }

    public void setFoods(ArrayList<Food> f){
        this.Foods = f;
    }

    public ArrayList<Food> getFoods() {
        return Foods;
    }
}
