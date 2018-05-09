package com.sp18.ssu370.baseprojectapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import Database.WineAndDineDatabase;

public class FoodList {
    //@SerializedName("matches")
    private ArrayList<Food> Foods = new ArrayList<Food>(){{
        add(new Food("cheese", "food info", "5156", new ArrayList<String>(){{
            add("crackers");
            add("peanut butter");
        }}, new ArrayList<String>(){{
            add("http://www.howmuchisin.com/produce_converters_app/vegetables_large/cheese.png");
        }}));

        add(new Food("eggs", "food info", "5156", new ArrayList<String>(){{
            add("crackers");
            add("peanut butter");
        }}, new ArrayList<String>(){{
            add("http://fedandfit.com/wp-content/uploads/2018/01/Hard-Boiled-Egg-200x200.jpg");
        }}));

        add(new Food("Name", "food info", "123", new ArrayList<String>(){{
            add("Test");
            add("Test2");
        }}, new ArrayList<String>(){{
            add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAAA1BMVEUAAACnej3aAAAAPUlEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA8GadCAABYe850QAAAABJRU5ErkJggg==");
        }}));

    }};

    public ArrayList<Food> getFoods() {
        return Foods;
    }
}
