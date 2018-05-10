package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.sp18.ssu370.baseprojectapp.ui.activities.FoodInfoActivity;

import org.parceler.Parcel;

import java.util.ArrayList;

import Database.FoodEntity;

public class Food {
    private String name = "test Food";

    private String Meal_Designation = "Meal_Designation";

    private String Meal_Type = "Meal_Type";

    private String source = "test display name";

    private String Address = "123456";

    private ArrayList<String> complements = new ArrayList<String>() {{
        add("test item 1");
        add("test item 2");
        add("test item 3");
    }};

    private ArrayList<String> thumbnailSources  = new ArrayList<String>() {{
        add("https://i.imgur.com/vtjlMSR.jpg");
    }};

    public Food(String name, String Meal_Designation, String Meal_Type, String Address, ArrayList<String> complements, ArrayList<String> thumbnailSources){
        this.name = name;
        this.Meal_Designation = Meal_Designation;
        this.Meal_Type = Meal_Type;
        this.Address = Address;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public ArrayList<String> getComplements() {
        return complements;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
