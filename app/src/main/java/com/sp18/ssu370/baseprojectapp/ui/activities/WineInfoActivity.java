package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.sp18.ssu370.baseprojectapp.R;

public class WineInfoActivity extends AppCompatActivity {

    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        profilebutton = findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineInfoActivity.this, ProfileActivity.class));
            }
        });

        mainactivitybutton = findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WineInfoActivity.this, MainActivity.class));
            }
        });

        mapbutton = findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WineInfoActivity.this, MapsActivity.class));
                //String address ;
                //openGMaps(address);
            }
        });
    }

    public void openGMaps(String address) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + address));
        startActivity(intent);
    }
}
