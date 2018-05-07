package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sp18.ssu370.baseprojectapp.R;

public class ProfileActivity extends AppCompatActivity {

    Dialog winePreferenceDialog;
    Dialog foodPreferenceDialog;
    Dialog matchesDialog;
    private Button profilebutton;
    private Button creatprofilebutton;
    private Button winepreferencebutton;
    private Button foodpreferencebutton;
    private Button matchbutton;
    private Button mainactivitybutton;
    private Button mapbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        winePreferenceDialog = new Dialog(this);
    }


    public void ShowWinePopup(View v) {
        TextView txtclose;
        winePreferenceDialog.setContentView(R.layout.popupwinepreference);
        txtclose = winePreferenceDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winePreferenceDialog.dismiss();
            }
        });
        winePreferenceDialog.show();

    }
}
    /*
    public void ShowMatchPopup(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popupmatches);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }
    public void ShowFoodPopup(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popupfoodpreference);
        txtclose = myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }






        profilebutton = (Button) findViewById(R.id.toProfileActivity);                                          // Profile button
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
            }
        }

        mainactivitybutton = (Button) findViewById(R.id.toMainActivity);                                        // Home button
        mainactivitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        }

        mapbutton = (Button) findViewById(R.id.FindLoc);                                                       // Map button
        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MapsActivity.class));
            }

        }
}

*/
