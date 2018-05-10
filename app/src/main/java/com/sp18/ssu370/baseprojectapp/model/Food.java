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

    private String Address = "123456";

    private ArrayList<String> complements = new ArrayList<String>();

    private ArrayList<String> thumbnailSources  = new ArrayList<String>();

    public String getMeal_Designation() {
        return Meal_Designation;
    }

    public String getMeal_Type() {
        return Meal_Type;
    }

    public String getAddress() {
        return Address;
    }

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

    public ArrayList<String> getComplements() {
        return complements;
    }

    public String getComplementsString() {
        String listString = "\n";
        for (String s : complements) {
            listString += s + "\n";
        }
        return listString;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}


