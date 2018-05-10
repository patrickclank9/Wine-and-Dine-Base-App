package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sp18.ssu370.baseprojectapp.R;

import org.w3c.dom.Text;

public class WineInfoActivity extends AppCompatActivity {

    public static final String WINE_TITLE = "wineExtraKey";
    public static final String IMAGE_URL = "wineURL";
    public static final String WINECOLOR = "mealType";
    public static final String WINEVARIETAL = "msdfasd";
    public static final String WINEABV = "asgsafg";
    public static final String WINEYEAR= "asgsdsfgsdafg";
    public static final String COMPLEMENTS = "complements";
    public static final String WINERY = "meald";
    public static final String ADDRESS = "address";

    private ImageButton profilebutton;
    private ImageButton mainactivitybutton;
    private ImageButton mapbutton;
    private TextView winename;
    private TextView winedetails;
    private TextView winecolor;
    private TextView complements;
    private TextView varietal;
    private TextView wineabv;
    private TextView wineyear;
    private ImageView thumbnailSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        Bundle b = getIntent().getExtras();

        winename = findViewById(R.id.textView);
        thumbnailSource = findViewById(R.id.image);
        complements = findViewById(R.id.wine_comp);
        winedetails = findViewById(R.id.details);
        winecolor = findViewById(R.id.detailsColor);
        varietal = findViewById(R.id.detailsVarietal);
        //wineabv = findViewById(R.id.detailsABV);
        //wineyear = findViewById(R.id.detailsYear);
        String s = "";


        if(b!=null) {
            winename.setText((String)b.get(WINE_TITLE));
            complements.setText((String)b.get(COMPLEMENTS));
            winedetails.setText((String)b.get(WINERY));
            winecolor.setText((String)b.get(WINECOLOR));
            varietal.setText((String)b.get(WINEVARIETAL));
            //wineabv.setText((String)b.get(WINEABV));
            //wineyear.setText((String)b.get(WINEYEAR));
            s = (String)b.get(ADDRESS);



            Glide.with(this)
                    .load(b.get(IMAGE_URL))
                    .into(thumbnailSource);
        }


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
                //openMaps(s);

            }
        });

    }
    public void openMaps(String address){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:0,0?q=" + address));
    }
}