package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;

public class ProfileActivity extends AppCompatActivity {
    Dialog winePreferenceDialog;

  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        winePreferenceDialog = new Dialog(this);
    }

}

