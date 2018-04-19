package com.sp18.ssu370.baseprojectapp.network;

import android.os.AsyncTask;

import com.sp18.ssu370.baseprojectapp.model.FoodList;
import com.sp18.ssu370.baseprojectapp.util.FoodParser;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FoodSearchAsyncTask extends AsyncTask<String, String, FoodList> {

    private final String baseApiUrl = "http://api.yummly.com/v1/api/Foods";
    private final String apiKey = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private final String appId = "4911b643";
    private OnFoodFetchResponse callbackListener;

    public void setCallbackListener(OnFoodFetchResponse callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    protected FoodList doInBackground(String... strings) {
        String searchParams = strings[0];

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        urlBuilder.addQueryParameter("_app_key", apiKey);
        urlBuilder.addQueryParameter("_app_id", appId);
        urlBuilder.addQueryParameter("your_search_parameters", searchParams);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Response response = null;

        try {
            response = client.newCall(request).execute();
            if (response != null) {
                return FoodParser.FoodListFromJson(response.body().string()); }
        } catch (IOException e) {
            // do something with exception
        }

        return null;
    }

    @Override
    protected void onPostExecute(FoodList FoodList) {
        super.onPostExecute(FoodList);
        callbackListener.onCallback(FoodList);
    }

    public interface OnFoodFetchResponse {
        void onCallback(FoodList FoodList);
    }
}
