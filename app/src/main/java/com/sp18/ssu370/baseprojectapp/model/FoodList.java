package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import Database.WineAndDineDatabase;

public class FoodList {
    //@SerializedName("matches")
    private ArrayList<Food> Foods = new ArrayList<Food>(){{
        add(new Food("cheese", "food info", "5156", new ArrayList<String>(){{
            add("Zinfandel");
            add("butter");
        }}, new ArrayList<String>(){{
            add("http://www.howmuchisin.com/produce_converters_app/vegetables_large/cheese.png");
        }}));

        add(new Food("eggs", "food info", "5156", new ArrayList<String>(){{
            add("crackers");
            add("peanut butter");
        }}, new ArrayList<String>(){{
            add("http://fedandfit.com/wp-content/uploads/2018/01/Hard-Boiled-Egg-200x200.jpg");
        }}));

    }};

    public ArrayList<Food> getFoods() {
        return Foods;
    }
}
