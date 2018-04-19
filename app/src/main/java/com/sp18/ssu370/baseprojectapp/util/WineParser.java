package com.sp18.ssu370.baseprojectapp.util;

import com.sp18.ssu370.baseprojectapp.model.WineList;
import com.google.gson.Gson;

public class WineParser {
    public static final WineList WineListFromJson(String responseString){
        Gson gson = new Gson();
        return gson.fromJson(responseString, WineList.class);
    }
}
