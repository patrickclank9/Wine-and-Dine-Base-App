package com.sp18.ssu370.baseprojectapp.model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

//@Parcel
public class Food {
    //@SerializedName("recipeName")
    private String name = "test Food";

    //@SerializedName("sourceDisplayName")
    private String source = "test display name";

    //@SerializedName("id")
    private String FoodId = "123456";

    //@SerializedName("ingredients")
    private ArrayList<String> complements = new ArrayList<String>() {{
        add("test item 1");
        add("test item 2");
        add("test item 3");
    }};

    //@SerializedName("smallImageUrls")
    private ArrayList<String> thumbnailSources  = new ArrayList<String>() {{
        add("https://i.imgur.com/vtjlMSR.jpg");
    }};

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getFoodId() {
        return FoodId;
    }

    public ArrayList<String> getComplements() {
        return complements;
    }

    public ArrayList<String> getThumbnailSources() {
        return thumbnailSources;
    }
}
