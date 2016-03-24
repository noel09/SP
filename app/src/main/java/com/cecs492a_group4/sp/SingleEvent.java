package com.cecs492a_group4.sp;

/*
 * Copyright (C) 2015 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */



import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.Html;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;


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




//--------

import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.Html;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.json.JSONException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.os.AsyncTask;



import com.cecs492a_group4.sp.android.common.activities.SampleActivityBase;

//import com.example.android.common.logger.Log;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.ProgressBar;
import android.os.Handler;
import android.view.View.OnClickListener;

import javax.xml.transform.Result;


public class SingleEvent extends AppCompatActivity implements PlaceSelectionListener, OnClickListener, CompoundButton.OnCheckedChangeListener,
                        ConnectionCallbacks, OnConnectionFailedListener {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    Random ran = new Random();
    String consumerKey = "dudmo3ssHxvpUP_i_Lw60A";
    String consumerSecret = "fOhwH5mUo_CyzX2D2vcDUc8FNw8";
    String token = "yPhkb0u9cRxGE8ikWRkH3ceMCCpKYpQA";
    String tokenSecret = "-WoZd39mwu4X9iVDXo5bxDNOBBU";
    int RandRestaurant;
    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
    String response;
    YelpParser yp = new YelpParser();
    URL newurl;
    String activity, img_url,rating_url ,rating, htmlname, htmldetail;
    Bitmap mIcon_val;
    URL icon_img;
    URL icon_url, url_rating;
    ArrayAdapter<DayEvent> arrayAdapter;
    int limit = 5;
    //double distance;
    Thread t1, t2;
    ImageView iv;
    TextView tv, tv2;
    Switch locationSwitch;
    public static String finalAddress;
    ListView listView;



    //---
    public static android.widget.ListView list_view;
    public ArrayList<DayEvent> dayevent = new ArrayList<DayEvent>();

    //private TextView mPlaceDetailsText;

    // private TextView mPlaceAttribution;

    //testing putting address in a temp address charsequence
    public static CharSequence address;
    public static String addressString;


    public GoogleApiClient mGoogleApiClient;
    public Location mLastLocation;
    public static Location staticLocation;
    public static String staticAddress;
    static  PlaceAutocompleteFragment autocompleteFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        listView = (ListView) findViewById(R.id.listView);
        buildGoogleApiClient();
        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);


        locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        // Register a listener to receive callbacks when a place has been selected or an error has
        // occurred.
        if(staticAddress != null){

            finalAddress = staticAddress;
            autocompleteFragment.setHint(staticAddress);

            Toast.makeText(this,"Using GSM location",
                    Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "test: " + finalAddress,
                    Toast.LENGTH_SHORT).show();
        }
        else{
            locationSwitch.toggle();
            Toast.makeText(this,("Please enter a location"),
                    Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "test: " + finalAddress,
                    Toast.LENGTH_SHORT).show();
        }

        locationSwitch.setOnCheckedChangeListener(this);
        yelp.setLimit(limit);
        autocompleteFragment.setOnPlaceSelectedListener(this);

        Button generator = (Button) findViewById(R.id.fulldaybtn);
        Button singlebutton = (Button) findViewById(R.id.singleDayBtn);


        //String htmlexample = "<body><h2>The Result<br></h2>";
        //tv.setText(Html.fromHtml(htmlexample, null, null));
        arrayAdapter = new MyDayListAdapter();
        listView.setAdapter(arrayAdapter);
        generator.setOnClickListener(this);
        singlebutton.setOnClickListener(this);



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information
    }


    public void onPlaceSelected(Place place) {
        // Log.i(TAG, "Place Selected: " + place.getName());

        // Format the returned place's details and display them in the TextView.
        //mPlaceDetailsText.setText(place.getAddress());

        //test placing address into addressTemp
        address = place.getAddress();
        addressString = address.toString();
        finalAddress = addressString;

        //---------------------------------------------------------------------------------------------------------------------------
        Toast.makeText(this,("Using entered location"),
                Toast.LENGTH_SHORT).show();
        if (locationSwitch.isChecked()) {
            locationSwitch.toggle();
        }

        Toast.makeText(this, "test: " + finalAddress,
                Toast.LENGTH_SHORT).show();
        //End catch
        //log to see if the address gets extracted //IT WORKS!!
        //Log.d("test: ", addressTempString);

        /*
        CharSequence attributions = place.getAttributions();
        if (!TextUtils.isEmpty(attributions)) {
            mPlaceAttribution.setText(Html.fromHtml(attributions.toString()));
        } else {
            mPlaceAttribution.setText("");
        }
        */
    }


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        //---------------------------------------------------------------------------------------------------------------------------
        if(isChecked && staticAddress != null) {
            Toast.makeText(this, ("Using GSM location"),
                    Toast.LENGTH_SHORT).show();
            finalAddress = staticAddress;
            autocompleteFragment.setText("");
            autocompleteFragment.setHint(staticAddress);

            Toast.makeText(this, "test: " + finalAddress,
                    Toast.LENGTH_SHORT).show();
        }
        else if(isChecked && staticAddress == null)    {
            Toast.makeText(this, ("Please enter a location"),
                    Toast.LENGTH_SHORT).show();
            locationSwitch.toggle();
            autocompleteFragment.setText("");
            finalAddress = null;

            Toast.makeText(this, "test: " + finalAddress,
                    Toast.LENGTH_SHORT).show();

        }
        else {
            if(finalAddress != addressString) {
                Toast.makeText(this, ("Please enter a location"),
                        Toast.LENGTH_SHORT).show();
                finalAddress = null;
            }
            autocompleteFragment.setText("");
            autocompleteFragment.setHint("");

            Toast.makeText(this, "test: " + finalAddress,
                    Toast.LENGTH_SHORT).show();

        }
    }

    public void onError(Status status) {
        //Log.e(TAG, "onError: Status = " + status.toString());
        System.out.println("Place selection failed:" + status.getStatusMessage());

    }


    private class MyDayListAdapter extends ArrayAdapter<DayEvent>{
        public MyDayListAdapter(){
            super(SingleEvent.this, R.layout.cubedayevent, dayevent);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View itemview = convertView;
                //Making sure that there is a view if the view is null
                if(itemview  == null)
                {
                    itemview = getLayoutInflater().inflate(R.layout.cubedayevent, parent, false);
                }

                //Find the items to work with
                DayEvent an_event = dayevent.get(position);

                //Fill the view
                TextView title = (TextView) itemview.findViewById(R.id.activity_title);
                title.setText(an_event.getActivitytitle());

                try{
                    ImageView  icon = (ImageView) itemview.findViewById(R.id.acivity_icon);
                    icon.setImageBitmap(an_event.Iconimg);


                    ImageView rating_img = (ImageView) itemview.findViewById(R.id.ratingImg);
                    rating_img.setImageBitmap(an_event.ratingimg);

                    TextView distance = (TextView) itemview.findViewById(R.id.distanceId);
                    distance.setText(an_event.distance + " mi");


                }catch (Exception a)
                {
                    System.out.println("SingleEvent/MyListAdapter :: Error =" + a.getMessage());
                }


                TextView criteria = (TextView) itemview.findViewById(R.id.criteria);
                criteria.setText(an_event.criteria);

                return itemview;
            }
        }




    private void setNull() {
        response = null;
        activity = null;
        rating = null;
        img_url = null;
        rating_url = null;
        icon_url = null;
        url_rating = null;
    }

    public synchronized void getYelpSearchResult(final String searchToken, final String Address) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            int randPick = ran.nextInt(limit);
            @Override
            public void run() {
             try {

                 System.out.println("Index: " + randPick);
                 response = yelp.searchByLocation(searchToken, Address);
                 System.out.println(searchToken + " gave me this response: " + response);
                 yp.setResponse(response);
                 yp.parseBusiness();

                 int nameSIndex = response.indexOf("\"name\"",1) + 8;
                 int imgSIndex = response.indexOf("\"image_url\"",1) + 13;
                 int ratingSIndex = response.indexOf("\"rating_img_url\"",1) + 18;
                 //int distanceSIndex = response.indexOf("\"distance\"",1) + 11;



                 for (int i = 0; i < randPick; i++) {
                     nameSIndex = response.indexOf("\"name\"",++nameSIndex) + 8;
                     imgSIndex = response.indexOf("\"image_url\"",++imgSIndex) + 13;
                     ratingSIndex = response.indexOf("\"rating_img_url\"",++ratingSIndex) + 18;
                 //    distanceSIndex = response.indexOf("\"distance\"",++distanceSIndex) + 11;
                 }
                 int ratingEIndex = response.indexOf("review_count",++ratingSIndex) - 4;
                 int nameEIndex = response.indexOf("snippet_image_url",++nameSIndex) - 4;
                 int imgEIndex = response.indexOf("location",++imgSIndex) - 4;
                 //int distanceEIndex = response.indexOf("}, {\"is_claimed",++distanceSIndex) - 1;

                 String distance = yp.getBusinessDistance(randPick);
//               distance = distance.substring(distanceSIndex,distanceEIndex);
                 System.out.println("Distance: " + distance);

                 double dis = Double.parseDouble(distance);
                 dis = Math.round(dis/162.61)/ 10.00;
                 System.out.println("Distance parse: " + dis);
                 String tmp = response;
                 tmp = tmp.substring(nameSIndex,nameEIndex);
                 System.out.println(tmp);
                 //activity = yp.getBusinessName(randPick);
                 activity = tmp;
                 //rating = yp.getBusinessRating(randPick);
                 //I am going to parse the url my self fucking yelp!

                // int imgEIndex = response.indexOf("location",imgSIndex) - 4;

                 String tmp2 = response;
                 tmp2 = tmp2.substring(imgSIndex,imgEIndex);
                 System.out.println("mylink " + tmp2);
                 //img_url = yp.getBusinessImageURL(randPick);
                 img_url = tmp2;
                 System.out.println(img_url);
                 //rating_url = yp.getBusinessRatingUrl(randPick);
                 String ratingURL = response;
                 ratingURL = ratingURL.substring(ratingSIndex,ratingEIndex);
                 System.out.println(ratingURL);
                 rating_url = ratingURL;
                 icon_url = new URL(img_url);
                 url_rating = new URL(rating_url);
                 dayevent.add(new DayEvent(activity, icon_url, url_rating, searchToken,dis));
             } catch (JSONException e) {
                 e.printStackTrace();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }

            }

        });
        thread.start();
        while (response == null){}
        while (activity == null){}
        //while (rating == null){}
        while (img_url==null){}
        while(rating_url == null){}
        thread.join();

    }


    public void onClick(View v) {
        if( finalAddress == null ){
            autocompleteFragment.setHint("Enter Address");
        }
        else {
            //setNull();
            RandRestaurant = ran.nextInt(limit);
            switch (v.getId()) {
                case R.id.fulldaybtn:
                    if (listView.getAdapter().getCount() == 5 || listView.getAdapter().getCount() >= 1) {
                        dayevent.clear();
                        arrayAdapter.notifyDataSetChanged();

                    }
                    System.out.println("List View has: " + listView.getAdapter().getCount());
                    try {
                        System.out.println("Full Day Event");
                        getYelpSearchResult("Breakfast", finalAddress);
                        getYelpSearchResult("Activity", finalAddress);
                        getYelpSearchResult("Lunch", finalAddress);
                        getYelpSearchResult("Activity", finalAddress);
                        getYelpSearchResult("Dinner", finalAddress);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arrayAdapter.notifyDataSetChanged();
                    break;

                case R.id.singleDayBtn:
                    if (listView.getAdapter().getCount() >= 1) {
                        dayevent.clear();
                        arrayAdapter.notifyDataSetChanged();

                    }
                    System.out.println("Single Day");
                    try {
                        getYelpSearchResult("Restaurant", finalAddress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arrayAdapter.notifyDataSetChanged();
                    break;
            }
        }

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

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

            //(latitude, longitude, 1)
            //33.777043, -118.114395, 1)

            Address address = list.get(0);


            StringBuffer str = new StringBuffer();

            if(address.getAddressLine(0) != null && address.getLocality() != null &&
                    address.getAdminArea() != null && address.getPostalCode() != null &&
                    address.getCountryName() != null){
                //str.append(address.getAddressLine(0) + ", ");
                //str.append(address.getLocality() + ", ");
                //str.append(address.getAdminArea() + " ");
                //str.append(address.getPostalCode() + ", ");
                //str.append(address.getCountryName());
                //str.append("USA");

                //String strAddress = str.toString();

                String strAddress = (address.getAddressLine(0)+ ", " + address.getLocality() + ", " + address.getAdminArea() + " " + address.getPostalCode() + ", " + "USA");


                return strAddress;
            }
            else{
                return null;
            }
        }

        return null;
    }


}


