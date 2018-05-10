package com.sp18.ssu370.baseprojectapp.model;

import java.util.ArrayList;

public class Food {
    private String name = "test Food";

    private String source = "test display name";

    private String FoodId = "123456";

    private ArrayList<String> complements = new ArrayList<String>() {{
        add("test item 1");
        add("test item 2");
        add("test item 3");
    }};

    private ArrayList<String> thumbnailSources  = new ArrayList<String>() {{
        add("https://i.imgur.com/vtjlMSR.jpg");
    }};

    public Food(String name, String source, String FoodId, ArrayList<String> complements, ArrayList<String> thumbnailSources){
        this.name = name;
        this.source = source;
        this.FoodId = FoodId;
        this.complements = complements;
        this.thumbnailSources = thumbnailSources;
    }

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
