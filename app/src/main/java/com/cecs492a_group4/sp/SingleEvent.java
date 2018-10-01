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



import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.text.Html;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
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

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
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
        ConnectionCallbacks, OnConnectionFailedListener, PopupMenu.OnMenuItemClickListener {


    /**
     * ATTENTION:  This was auto-generated to implement the App Indexing API.
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
    String activity, img_url, rating_url, web_url, phoneNum, event_address;
    Bitmap mIcon_val;
    URL icon_img;
    URL icon_url, url_rating;
    ArrayAdapter<DayEvent> arrayAdapter;
    int limit = 20;
    Thread t1, t2;
    ImageView iv;
    TextView tv, tv2;
    Switch locationSwitch;
    public static String finalAddress;
    ListView listView;
    int globalPosition;

    Button fullButton, singleButton, shareButton;
    ImageView removeEvent;
    ShareDialog shareDialog;
    CallbackManager callbackManager;
    ShareLinkContent linkContent;
    SharePhoto photo;
    SharePhotoContent content;
    ArrayList<String> bussinessNames = new ArrayList<>(5);

    private ProgressDialog loadingSpinner;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();

    boolean fullDayPlan = false;


    View senderView;

    //---
    public static ListView list_view;
    public ArrayList<DayEvent> dayevent = new ArrayList<DayEvent>();

    //private TextView mPlaceDetailsText;

    // private TextView mPlaceAttribution;

    //testing putting address in a temp address charsequence
    public static CharSequence address;
    public static String addressString;
    public static int currentRadius = 10;


    public GoogleApiClient mGoogleApiClient;
    public Location mLastLocation;
    public static Location staticLocation;
    public static String staticAddress;
    static PlaceAutocompleteFragment autocompleteFragment = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        listView = (ListView) findViewById(R.id.listView);
        buildGoogleApiClient();
        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.getView().setBackgroundColor(Color.WHITE);

        shareDialog = new ShareDialog(this);
        callbackManager = CallbackManager.Factory.create();


        locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        // Register a listener to receive callbacks when a place has been selected or an error has
        // occurred.
        if (staticAddress != null) {

            finalAddress = staticAddress;
            autocompleteFragment.setHint(staticAddress);

            Toast.makeText(this, "Using GSM location",
                    Toast.LENGTH_SHORT).show();


        } else {
            locationSwitch.toggle();
            Toast.makeText(this, ("Please enter a location"),
                    Toast.LENGTH_SHORT).show();


        }

        locationSwitch.setOnCheckedChangeListener(this);
        yelp.setLimit(limit);
        autocompleteFragment.setOnPlaceSelectedListener(this);

        fullButton = (Button) findViewById(R.id.fulldaybtn);
        singleButton = (Button) findViewById(R.id.singleDayBtn);
        Typeface buttonfont = Typeface.createFromAsset(getAssets(), "PoisonedApples.ttf");
        fullButton.setTypeface(buttonfont);
        singleButton.setTypeface(buttonfont);


        //String htmlexample = "<body><h2>The Result<br></h2>";
        //tv.setText(Html.fromHtml(htmlexample, null, null));
        arrayAdapter = new MyDayListAdapter();
        listView.setAdapter(arrayAdapter);
        fullButton.setOnClickListener(this);
        singleButton.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DayEvent clickedevent = dayevent.get(position);
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickedevent.url));
                    startActivity(myIntent);
                } catch (Exception e) {
                    System.out.println("Been in on click method");
                }
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
        Toast.makeText(this, ("Using entered location"),
                Toast.LENGTH_SHORT).show();
        if (locationSwitch.isChecked()) {
            locationSwitch.toggle();
        }


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
        if (isChecked && staticAddress != null) {
            Toast.makeText(this, ("Using GSM location"),
                    Toast.LENGTH_SHORT).show();
            finalAddress = staticAddress;
            autocompleteFragment.setText("");
            autocompleteFragment.setHint(staticAddress);


        } else if (isChecked && staticAddress == null) {
            Toast.makeText(this, ("Please enter a location"),
                    Toast.LENGTH_SHORT).show();
            locationSwitch.toggle();
            autocompleteFragment.setText("");
            finalAddress = null;


        } else {
            if (finalAddress != addressString) {
                Toast.makeText(this, ("Please enter a location"),
                        Toast.LENGTH_SHORT).show();
                finalAddress = null;
            }
            autocompleteFragment.setText("");
            autocompleteFragment.setHint("");


        }
    }

    public void onError(Status status) {
        //Log.e(TAG, "onError: Status = " + status.toString());
        System.out.println("Place selection failed:" + status.getStatusMessage());

    }


    private class MyDayListAdapter extends ArrayAdapter<DayEvent> {
        public MyDayListAdapter() {
            super(SingleEvent.this, R.layout.cubedayevent, dayevent);
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View itemview = convertView;
            //Making sure that there is a view if the view is null
            if (itemview == null) {
                itemview = getLayoutInflater().inflate(R.layout.cubedayevent, parent, false);
            }

            //Find the items to work with
            DayEvent an_event = dayevent.get(position);

            //Fill the view
            TextView title = (TextView) itemview.findViewById(R.id.activity_title);
            title.setText(an_event.getActivitytitle());

            try {
                ImageView icon = (ImageView) itemview.findViewById(R.id.activity_icon);
                icon.setImageBitmap(an_event.Iconimg);


                ImageView rating_img = (ImageView) itemview.findViewById(R.id.ratingImg);
                rating_img.setImageBitmap(an_event.ratingimg);

                TextView distance = (TextView) itemview.findViewById(R.id.distanceId);
                distance.setText(an_event.distance + " mi");
                ImageView deleteButton = (ImageView) itemview.findViewById(R.id.deleteItem);
                deleteButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        arrayAdapter.remove(dayevent.get(position));
                        arrayAdapter.notifyDataSetChanged();
                    }
                });

                ImageView fb = (ImageView) itemview.findViewById(R.id.FBshare);
                fb.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                .setContentTitle("Take Me Out!")
                                .setContentDescription(
                                        "I'm going to " + dayevent.get(position).getActivitytitle())
                                .setImageUrl(Uri.parse(dayevent.get(position).getImageurl().toString()))
                                        //.setShareHashtag(new ShareHashtag.Builder()
                                        //      .setHashtag("#ConnectTheWorld")
                                        //    .build());
                                        //.setQuote("Connect on a global scale.")
                                .build();
                        shareDialog.show(linkContent);

                    }
                });


                ImageView renewButton = (ImageView) itemview.findViewById(R.id.renewItem);
                renewButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        arrayAdapter.remove(dayevent.get(position));
                        globalPosition = position;
                        new RefreshPlan().execute();
                    }
                });

                ImageView callButton = (ImageView) itemview.findViewById(R.id.call);
                callButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + dayevent.get(position).phoneNumber));
                        try{
                            startActivity(callIntent);
                        } catch (android.content.ActivityNotFoundException ex){
                            Toast.makeText(getApplicationContext(),"Call permission denied ",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                ImageView direction = (ImageView) itemview.findViewById(R.id.dir);
                direction.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        String map = "http://maps.google.co.in/maps?q=" + dayevent.get(position).address;
                        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(map));
                        startActivity(i);
                    }
                });

            } catch (Exception a) {
                System.out.println("SingleEvent/MyListAdapter :: Error =" + a.getMessage());
            }


            TextView criteria = (TextView) itemview.findViewById(R.id.criteria);
            criteria.setText(an_event.criteria);

            return itemview;
        }
    }


    public synchronized void getYelpSearchResult(final int index1, final String searchToken, final String Address) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int randPick = ran.nextInt(limit);
                try {
                    String name = "ldkfldsjkfd";
                    int full = 0;
                    do {

                        randPick = ran.nextInt(limit);
                        System.out.println("Event number : " + index1);
                        System.out.println(randPick);
                        System.out.println("Index: " + randPick);
                        response = yelp.searchByLocation(searchToken, Address, SingleEvent.currentRadius);
                        System.out.println("The current radius : " + SingleEvent.currentRadius);
                        System.out.println(searchToken + " gave me this response: " + response);
                        yp.setResponse(response);
                       // yp.parseBusiness();

                        int nameSIndex = response.indexOf("\"name\"", 1) + 8;

                        for (int i = 0; i < randPick; i++) {
                            nameSIndex = response.indexOf("\"name\"", ++nameSIndex) + 8;
                        }
                        int nameEIndex = response.indexOf("\",", ++nameSIndex);

                        String tmp = response;
                        name = tmp.substring(nameSIndex, nameEIndex);
                        System.out.println(name);
                        full++;
                        if (full >= 4) {
                            full = 0;
                            bussinessNames.clear(); //no more options reset array
                        }
                    } while (bussinessNames.contains(name));

                    try {
                        bussinessNames.add(index1, name);
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Array size " + bussinessNames.size());
                        bussinessNames.clear();
                    }
                    int imgSIndex = response.indexOf("\"image_url\"", 1) + 13;
                    int ratingSIndex = response.indexOf("\"rating_img_url\"", 1) + 18;
                    int urlSIndex = response.indexOf("\"mobile_url\"", 1) + 14;
                    int phoneSIndex = response.indexOf("\"phone\":", 1) + 9;
                    int addressSIndex = response.indexOf("\"display_address\"", 1) + 19;
                    int distanceSIndex = response.indexOf("\"distance\"", 1) + 12;
                    System.out.println("Start index :" + distanceSIndex);
                    for (int i = 0; i < randPick; i++) {

                        imgSIndex = response.indexOf("\"image_url\"", ++imgSIndex) + 13;
                        ratingSIndex = response.indexOf("\"rating_img_url\"", ++ratingSIndex) + 18;
                        urlSIndex = response.indexOf("\"mobile_url\"", ++urlSIndex) + 14;
                        phoneSIndex = response.indexOf("\"phone\":", ++phoneSIndex) + 9;
                        addressSIndex = response.indexOf("\"display_address\"", ++addressSIndex) + 19;
                        distanceSIndex = response.indexOf("\"distance\"", ++distanceSIndex) + 12;
                    }

                    int ratingEIndex = response.indexOf("g\"", ++ratingSIndex) + 1;
                    int imgEIndex = response.indexOf("g\"", ++imgSIndex) + 1;
                    int phoneEIndex = response.indexOf("\",", ++phoneSIndex);
                    int urlEIndex = response.indexOf("rating_img_url", ++urlSIndex) - 4;
                    int addressEIndex = response.indexOf("\"], ", ++addressSIndex) + 1;


                    //System.out.println("distance = " + response.substring(distanceSIndex,distanceSIndex + 9));
                    //String distance = yp.getBusinessDistance(randPick);
                    String distance = response.substring(distanceSIndex, distanceSIndex + 9);
                    System.out.println("Distance: " + distance);
                    double dis;
                    try {
                        dis = Double.parseDouble(distance);
                    }catch (NumberFormatException e){
                        dis = 0.0;
                    }
                    System.out.println("Distance in meters:" + dis);
                    System.out.println("Distance in miles:" + meters_to_miles(dis));
                    BigDecimal bd = new BigDecimal(meters_to_miles(dis));
                    bd = bd.round(new MathContext(2));
                    dis = bd.doubleValue();
                    System.out.println("dis after conversion " + dis);
                    //distance = distance.substring(distanceSIndex,distanceEIndex);

                    //activity = yp.getBusinessName(randPick);
                    activity = name;
                    //rating = yp.getBusinessRating(randPick);
                    //I am going to parse the url my self fucking yelp!

                    // int imgEIndex = response.indexOf("location",imgSIndex) - 4;
                    String phoneNumber = response;
                    phoneNumber = phoneNumber.substring(phoneSIndex, phoneEIndex);
                    System.out.println("Phone number: " + phoneNumber);
                    String tmp2 = response;
                    tmp2 = tmp2.substring(imgSIndex, imgEIndex);
                    System.out.println("mylink " + tmp2);
                    //img_url = yp.getBusinessImageURL(randPick);
                    img_url = tmp2;
                    System.out.println(img_url);
                    //rating_url = yp.getBusinessRatingUrl(randPick);
                    String ratingURL = response;
                    ratingURL = ratingURL.substring(ratingSIndex, ratingEIndex);
                    System.out.println(ratingURL);


                    String weburl = response;
                    weburl = weburl.substring(urlSIndex, urlEIndex);
                    System.out.println("Event URL: " + weburl);


                    String eventaddress = response;
                    eventaddress = eventaddress.substring(addressSIndex, addressEIndex);

                    System.out.println("default Event Address" + eventaddress);

                    int streaddSindex = eventaddress.indexOf("\"") + 1;

                        int streaddEindex = eventaddress.indexOf("\",");
                        int cityaddSindex = 1;
                        try {
                            cityaddSindex = eventaddress.indexOf("\", \"") + 4;
                        } catch (StringIndexOutOfBoundsException e) {
                            cityaddSindex = 0;
                            System.out.println("No city");
                        }

                    String streetadd = " ";
                    try {
                        streetadd = eventaddress.substring(streaddSindex, streaddEindex);
                    }catch (StringIndexOutOfBoundsException e){
                        if (!Character.isDigit(eventaddress.charAt(0))) {
                            System.out.println("Faulty address");
                            streetadd = " ";
                        }
                    }
                    System.out.println("Street address:" + streetadd);
                    String cityadd;
                    if (cityaddSindex != 0)
                        cityadd = eventaddress.substring(cityaddSindex).replace("\"", "");
                    else
                        cityadd = " ";

                    System.out.println("City location: " + cityadd);
                    eventaddress = streetadd +" "+ cityadd;
                    System.out.println("adjusted Event Address: " + eventaddress);


                    //System.out.println(ratingURL);
                    event_address = eventaddress;
                    phoneNum = phoneNumber;
                    web_url = weburl;
                    rating_url = ratingURL;
                    icon_url = new URL(img_url);
                    url_rating = new URL(rating_url);
                    try {
                        dayevent.add(index1, new DayEvent(activity, icon_url, url_rating, searchToken, dis, web_url, phoneNum, event_address));
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Size of day event " + dayevent.size());
                    }
                //} catch (JSONException e) {
                    //e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
        thread.start();
        //test by removing the while loops (bad practice)
 /**       while (response == null) {
        }
        while (activity == null) {
        }
        while (web_url == null) {
        }
        while (img_url == null) {
        }
        while (rating_url == null) {
        }**/
        thread.join();

    }


    public double meters_to_miles(double meters) {
        return meters * 0.00062137;
    }


    public void onClick(View v) {
        senderView = v;

        if (finalAddress == null) {
            autocompleteFragment.setHint("Enter Address");
        } else {
            fullButton.setEnabled(false);
            singleButton.setEnabled(false);
            //setNull();
            RandRestaurant = ran.nextInt(limit);
            switch (v.getId()) {
                case R.id.fulldaybtn:
                    bussinessNames.clear();
                    if (listView.getAdapter().getCount() == 5 || listView.getAdapter().getCount() >= 1) {
                        dayevent.clear();
                        arrayAdapter.notifyDataSetChanged();

                    }
                    fullDayPlan = true;
                    System.out.println("List View has: " + listView.getAdapter().getCount());

                    break;

                case R.id.singleDayBtn:
                    bussinessNames.clear();
                    if (listView.getAdapter().getCount() >= 1) {
                        dayevent.clear();
                        arrayAdapter.notifyDataSetChanged();

                    }
                    fullDayPlan = false;
                    System.out.println("Single Day");

                    break;
            }
            new GeneratePlanTask().execute();
        }
        fullButton.setEnabled(true);
        singleButton.setEnabled(true);
        progressBarStatus = 100;
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        mGoogleApiClient.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SingleEvent Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.cecs492a_group4.sp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SingleEvent Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.cecs492a_group4.sp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    public void onConnected(Bundle connectionHint) {
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {

            mLastLocation.getLatitude();

            mLastLocation.getLongitude();

            staticLocation = mLastLocation;


            try {
                staticAddress = reverseGeocode(staticLocation.getLatitude(), staticLocation.getLongitude());
            } catch (IOException i) {
            }

            //Toast.makeText(this, " Lat: " + staticLocation.getLatitude() + " Long: " + staticLocation.getLongitude()
            //              + " Address: " + staticAddress,
            //     Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Failed to connect-lastknownlocation: Plese enter an address instead", Toast.LENGTH_LONG).show();
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

        if (gc.isPresent()) {
            List<Address> list = gc.getFromLocation(latitude, longitude, 1);

            //(latitude, longitude, 1)
            //33.777043, -118.114395, 1)

            Address address = list.get(0);


            StringBuffer str = new StringBuffer();

            if (address.getAddressLine(0) != null && address.getLocality() != null &&
                    address.getAdminArea() != null && address.getPostalCode() != null &&
                    address.getCountryName() != null) {
                //str.append(address.getAddressLine(0) + ", ");
                //str.append(address.getLocality() + ", ");
                //str.append(address.getAdminArea() + " ");
                //str.append(address.getPostalCode() + ", ");
                //str.append(address.getCountryName());
                //str.append("USA");

                //String strAddress = str.toString();

                String strAddress = (address.getAddressLine(0) + ", " + address.getLocality() + ", " + address.getAdminArea() + " " + address.getPostalCode() + ", " + "USA");


                return strAddress;
            } else {
                return null;
            }
        }

        return null;
    }

    //Test example Abdullah
    public int testingmethod(int first, int second) {
        return first + second;
    }

    public void getYelpResponse() {

    }





    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();

    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.radius:
                Intent popRadius = new Intent(this, PopRadius.class);
                this.startActivity(popRadius);
                return true;

            case R.id.signout:
                LoginManager.getInstance().logOut();
                finish();
                return true;

            case R.id.about:
                Intent popWindow = new Intent(this, Pop.class);
                this.startActivity(popWindow);
                return true;

            case R.id.tutorial:

                Intent tutorial = new Intent(this, Tutorial.class);
                this.startActivity(tutorial);

                return true;

            default:

                return false;
        }
    }


    public class GeneratePlanTask extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
            progressBarStatus = 0;

            loadingSpinner = new ProgressDialog(senderView.getContext());
            loadingSpinner.setCancelable(false);
            loadingSpinner.setMessage("Generating a plan ...");
            loadingSpinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            loadingSpinner.setProgress(0);
            loadingSpinner.setMax(100);
            loadingSpinner.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            if (fullDayPlan) {
                try {
                    System.out.println("Full Day Event");
                    getYelpSearchResult(0, "Breakfast", finalAddress);
                    getYelpSearchResult(1, "Activity", finalAddress);
                    getYelpSearchResult(2, "Lunch", finalAddress);
                    getYelpSearchResult(3, "Activity", finalAddress);
                    getYelpSearchResult(4, "Dinner", finalAddress);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    getYelpSearchResult(0, "Restaurant", finalAddress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            arrayAdapter.notifyDataSetChanged();
            loadingSpinner.dismiss();
        }
    }

    private class RefreshPlan extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
            progressBarStatus = 0;

            loadingSpinner = new ProgressDialog(senderView.getContext());
            loadingSpinner.setCancelable(false);
            loadingSpinner.setMessage("Replacing a business ...");
            loadingSpinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            loadingSpinner.setProgress(0);
            loadingSpinner.setMax(100);
            loadingSpinner.show();

        }

        @Override
        protected Void doInBackground(Void... params) {

            if (globalPosition % 2 != 0) {
                try {
                    getYelpSearchResult(globalPosition, "Activity", finalAddress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (globalPosition == 0) {
                try {
                    getYelpSearchResult(globalPosition, "Breakfast", finalAddress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (globalPosition == 2) {
                try {
                    getYelpSearchResult(globalPosition, "Lunch", finalAddress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (globalPosition == 4) {
                try {
                    getYelpSearchResult(globalPosition, "Dinner", finalAddress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            arrayAdapter.notifyDataSetChanged();
            loadingSpinner.dismiss();
        }
    }
}


