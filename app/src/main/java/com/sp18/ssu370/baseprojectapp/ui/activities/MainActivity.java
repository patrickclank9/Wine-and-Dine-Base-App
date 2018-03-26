package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sp18.ssu370.baseprojectapp.MapsActivity;
import com.sp18.ssu370.baseprojectapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //called when user taps find location
    public void FindLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
