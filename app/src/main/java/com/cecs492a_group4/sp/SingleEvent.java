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


public class SingleEvent extends AppCompatActivity implements PlaceSelectionListener, OnClickListener, CompoundButton.OnCheckedChangeListener {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    boolean functionSwitch;
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
    double distance;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        listView = (ListView) findViewById(R.id.listView);
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Register a listener to receive callbacks when a place has been selected or an error has
        // occurred.
        finalAddress = MainActivity.staticAddress;

        locationSwitch = (Switch) findViewById(R.id.locationSwitch);

        if (locationSwitch != null) {
            locationSwitch.setOnCheckedChangeListener(this);
        }
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

    public void onError(Status status) {
        //Log.e(TAG, "onError: Status = " + status.toString());
        System.out.println("Place selection failed:" + status.getStatusMessage());

    }



    private void populateDaylistview() {
        //System.out.println("Created a listview");

        //Build an adapter

        ArrayAdapter<DayEvent> adapter = new MyDayListAdapter();
        //System.out.println("Created an arrayadapter");

        try{
            listView.setAdapter(adapter);
            //System.out.println("Connected the list to the adapter");
        }catch (Exception e)
        {
            System.out.println("Adapter Error: " + e.getMessage() + "\n" + listView.getAdapter());

        }


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

                    //rating_img = (ImageView) itemview.findViewById(R.id.img_icon);
                    //rating_img.setImageBitmap(an_event.ratingimg);


                }catch (Exception a)
                {
                    System.out.println("SingleEvent/MyListAdapter :: Error =" + a.getMessage());
                }


                //TextView criteria = (TextView) itemview.findViewById(R.id.);
                //criteria.setText(an_event.criteria);

                return itemview;
            }
        }




    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            finalAddress = MainActivity.staticAddress;
        } else {
            finalAddress = addressString;
        }
        Toast.makeText(this, (isChecked ? "Using GSM location" : "Please enter a location"),
                Toast.LENGTH_SHORT).show();
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
                 int nameSIndex = response.indexOf("\"name\"") + 9;
                 int imgSIndex = response.indexOf("\"image  _url\"") + 14;


                 for (int i = 0; i < randPick; i++) {
                     nameSIndex = response.indexOf("\"name\"",++nameSIndex) + 9;
                     imgSIndex = response.indexOf("\"image_url\"",++imgSIndex) + 14;
                 }
                 int nameEIndex = response.indexOf("snippet_image_url",nameSIndex) - 4;
                 String tmp = response;
                 tmp = tmp.substring(nameSIndex,nameEIndex);
                 System.out.println(tmp);
                 activity = yp.getBusinessName(randPick);
                 activity = tmp;
                 rating = yp.getBusinessRating(randPick);
                 //I am going to parse the url my self fucking yelp!

                 int imgEIndex = response.indexOf("location",imgSIndex) - 4;

                 String tmp2 = response;
                 tmp2 = tmp2.substring(imgSIndex,imgEIndex);
                 System.out.println("mylink " + tmp2);
                 //img_url = yp.getBusinessImageURL(randPick);
                 img_url = tmp2;
                 System.out.println(img_url);
                 rating_url = yp.getBusinessRatingUrl(randPick);
                 icon_url = new URL(img_url);
                 url_rating = new URL(rating_url);
                 dayevent.add(new DayEvent(activity, icon_url, url_rating, searchToken));
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
        while (rating == null){}
        while (img_url==null){}
        while(rating_url == null){}
        thread.join();

    }


    public void onClick(View v) {
        //setNull();
        RandRestaurant = ran.nextInt(limit);
        switch (v.getId()) {
            case R.id.fulldaybtn:
                if (listView.getAdapter().getCount() >= 1) {
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







                /*-------------Old Way-----------
                for (int i = 0; i < 5; i++) {
                    t1 = new Thread() {
                        public void run() {

                            try {

                                int randPick = ran.nextInt(limit);
                                response = yelp.searchByLocation("Restaurants", finalAddress);
                                System.out.println(finalAddress);
                                yp.setResponse(response);

                                yp.parseBusiness();
                                activity = yp.getBusinessName(randPick);
                                rating = yp.getBusinessRating(randPick);
                                img_url = yp.getBusinessImageURL(randPick);
                                rating_url = yp.getBusinessRatingUrl(randPick);
                                icon_url = new URL(img_url);
                                url_rating = new URL(rating_url);
                                dayevent.add(new DayEvent(activity, icon_url, url_rating, "Restaurants"));
                                //dayevent.clear();


                            } catch (Exception e) {
                                System.out.println("\n\n\nThread1Error:" + e.getMessage());
                            }//End catch

                    }//End run
                } ; //End thread

                t1.start();
        }//end forloop
                if (dayevent.size() >= 5){
                    dayevent.clear();
                    System.out.println("Full");
                }
                else {
                    populateDaylistview();
                    System.out.println("Populate");
                }
              -------------------Till Here

                break;//For Full Day event
            */
        case R.id.singleDayBtn:
            if ( listView.getAdapter().getCount() >= 1) {
                dayevent.clear();
                arrayAdapter.notifyDataSetChanged();

            }
            System.out.println("Single Day");
            try {
                getYelpSearchResult("Lunch", finalAddress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayAdapter.notifyDataSetChanged();
            break;
//        t2 = new Thread() {
//            public void run() {
//                yelp.setLimit(limit);
//                try {
//                    int randPick = ran.nextInt(limit);
//                    response = yelp.searchByLocation("Restaurant", addressString);
//                    yp.setResponse(response);
//                    yp.parseBusiness();
//                    activity = yp.getBusinessName(randPick);
//                    rating   = yp.getBusinessRating(randPick);
//                    img_url  = yp.getBusinessImageURL(randPick);
//                    rating_url = yp.getBusinessRatingUrl(randPick);
//                    icon_url = new URL(img_url);
//                    url_rating = new URL(rating);
//                    singlevent.add(new DayEvent(activity, icon_url, url_rating, "Resturant"));
//                    System.out.println("Included: "+ singlevent.get(0).activitytitle);
//
//                } catch (Exception e) {
//                    System.out.println("\n\n\nThread2Error:" + e.getMessage());
//                }//End catch
//
//            }//End run
//        }; //End thread
        //t2.start();
        //populateSinglelistview();



        }

    }



//  MyAsyncTask update = new MyAsyncTask();
//    update.execute();
//    private class MyAsyncTask extends AsyncTask<String, Void, Void> {
//
//        String name;
//
//        public MyAsyncTask(String name) {
//            this.name = name;
//        }
//
//        @Override
//        protected Void doInBackground(String... params) {
//            try {
//
//                int randPick = ran.nextInt(limit);
//
//                response = yelp.searchByLocation("Restaurants", finalAddress);
//                System.out.println("1");
//                yp.setResponse(response);
//                System.out.println("2");
//                yp.parseBusiness();
//                System.out.println("3");
//                activity = yp.getBusinessName(randPick);
//                System.out.println("4");
//                rating = yp.getBusinessRating(randPick);
//                System.out.println("5");
//                img_url = yp.getBusinessImageURL(randPick);
//                System.out.println("6");
//                //rating_url = yp.getBusinessRatingUrl(randPick);
//                icon_img = new URL(img_url);
//                System.out.println("7");
//                //url_rating = new URL(rating_url);
//                DayEvent day = new DayEvent(activity, icon_img);
//                dayevent.add(day);
//                //onPostExecute(activity,icon_img);
//                System.out.println("8");
//            } catch (Exception e) {
//                System.out.println("\n\n\nThread1Error:" + e.getMessage());
//            }
//
//            return null;
//        }
//
//        protected void onPreExecute() {
//            // Runs on the UI thread before doInBackground
//            // Good for toggling visibility of a progress indicator
//            //need to create the progress abar
//            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
//            progressBar.setVisibility(ProgressBar.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//
//        }
//
//        protected void onProgressUpdate(Void... values) {
//            // Executes whenever publishProgress is called from doInBackground
//            // Used to update the progress indicator
//
//
//            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
//
//            progressBar.setProgress(0);
//
//        }
//
//
//        protected void onPostExecute() {
//            // This method is executed in the UIThread
//            // with access to the result of the long running task
//
//
//
//            //imageView.setImageBitmap(result);
//            /// Hide the progress bar
//
//            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
//            progressBar.setVisibility(ProgressBar.INVISIBLE);
//
//        }
//    }

}

