package com.sp18.ssu370.baseprojectapp.ui.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sp18.ssu370.baseprojectapp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.google.android.gms.location.places.Places;
//import com.google.android.gms.location.places.PlaceDetectionClient;
//import com.google.android.gms.location.places.GeoDataClient;

public class
MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //private boolean myLocation = true;
    private boolean mLocationPermissionGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1997;
    private static final float DEFAULT_ZOOM = 15f;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    //private GeoDataClient mGeoDataClient;
    //private PlaceDetectionClient mPlaceDetectionClient;


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getLocationPermission();
        init();
        //getDeviceLocation();
    }
    private void init(){
        EditText locationSearch = findViewById(R.id.editText);
        locationSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        || event.getAction() == KeyEvent.KEYCODE_ENTER) {

                    geoLocate();
                }
                return false;
            }
        });
    }
    private void geoLocate(){
        EditText locationSearch = findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals("")){
            Geocoder geocoder = new Geocoder(MapsActivity.this);
            try{
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e){
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            String string = addressList.get(0).getLocality() + ", ";
            string += addressList.get(0).getCountryName();
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            locationSearch.clearComposingText();
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title(string));
            //computeHeading(C);
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            hideSoftKeyboard();
        }
    }
    private void getDeviceLocation(){
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
            if(mLocationPermissionGranted){
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Location currentLocation = (Location)task.getResult();
                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLatitude()),
                                    DEFAULT_ZOOM);
                        }
                        else {
                            Toast.makeText(MapsActivity.this, "unable to get current Location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            //Log.e(TAG, "get DeviceLoction: Security Exception" + e.getMessage());
        }
    }
    private void moveCamera(LatLng latLng, float zoom){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        hideSoftKeyboard();
    }
    private void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] myPermissions, @NonNull int[]grantResults){
        mLocationPermissionGranted = false;
        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionGranted = true;
                    initMap();
                }
            }
        }


    }

    private void getLocationPermission() { //check if location permissions are granted
        String[] MyPermissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this, MyPermissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mLocationPermissionGranted){
            getDeviceLocation();

        }
        //mMap.setMyLocationEnabled(true);

    }
    public void onMapSearch(View view){
        EditText locationSearch = findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals("")){
            Geocoder geocoder = new Geocoder(MapsActivity.this);
            try{
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e){
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            String string = addressList.get(0).getLocality() + ", ";
            string += addressList.get(0).getCountryName();
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            //locationSearch.clearComposingText();
            //mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title(string));
            //computeHeading(C);
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            hideSoftKeyboard();
        }
    }

    private void hideSoftKeyboard(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

