package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sp18.ssu370.baseprojectapp.R;

public class WineTypeActivity extends AppCompatActivity {

    private Button mainactivitybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_type);

        mainactivitybutton = (Button) findViewById(R.id.toMainActivity);
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineTypeActivity.this, MainActivity.class));
            }
        });
    }
}
