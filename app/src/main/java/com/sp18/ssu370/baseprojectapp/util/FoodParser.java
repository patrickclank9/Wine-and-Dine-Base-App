package com.sp18.ssu370.baseprojectapp.util;

import com.sp18.ssu370.baseprojectapp.model.FoodList;
import com.google.gson.Gson;

public class FoodParser {
    public static final FoodList FoodListFromJson(String responseString){
        Gson gson = new Gson();
        return gson.fromJson(responseString, FoodList.class);
    }
}
