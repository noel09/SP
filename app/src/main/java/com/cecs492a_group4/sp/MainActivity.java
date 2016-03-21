package com.cecs492a_group4.sp;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.location.Geocoder;




import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

import android.location.Location;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;


public class MainActivity extends AppCompatActivity implements
        ConnectionCallbacks, OnConnectionFailedListener {

    public GoogleApiClient mGoogleApiClient;
    public Location mLastLocation;
    public static Location staticLocation;
    public static String staticAddress;
    public static String test;


    private AccessTokenTracker accessTokenTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildGoogleApiClient();
        FacebookSdk.sdkInitialize(getApplicationContext());



        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                updateWithToken(newAccessToken);
            }

        };
        Intent login = new Intent(this,login.class);
        startActivity(login);

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle connectionHint)  {
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.

        int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION);

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {

            mLastLocation.getLatitude();

            mLastLocation.getLongitude();

            staticLocation = mLastLocation;



            try {
                staticAddress = reverseGeocode(staticLocation.getLatitude(), staticLocation.getLongitude());
            }catch(IOException i){}

            Toast.makeText(this, " Lat: " + staticLocation.getLatitude() + " Long: " + staticLocation.getLongitude()
                            + " Address: " + staticAddress,
                    Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Failed to connect-lastknownlocation", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        //Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }


    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        //Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }



    public String reverseGeocode(double latitude, double longitude) throws IOException {
        Geocoder gc = new Geocoder(this);

        if(gc.isPresent()) {
            List<Address> list = gc.getFromLocation(latitude, longitude, 1);

            Address address = list.get(0);


            StringBuffer str = new StringBuffer();
            str.append(address.getAddressLine(0) + ", ");
            str.append(address.getLocality() + ", ");
            str.append(address.getAdminArea() + ", ");
            str.append(address.getCountryName());

            String strAddress = str.toString();
            return strAddress;
        }

        return null;
    }

    private void updateWithToken(AccessToken currentAccessToken) {
        if (currentAccessToken != null) {
            Intent activity = new Intent(this,SingleEvent.class);
            startActivity(activity);

        } else {
            Intent login = new Intent(this,login.class);
            startActivity(login);

        }
    }


}
