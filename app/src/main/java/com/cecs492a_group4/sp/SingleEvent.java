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







public class SingleEvent extends AppCompatActivity {


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
    String activity, img_url, rating, htmlname, htmldetail;
    Bitmap mIcon_val;

    int limit = 5;
    double distance;
    Thread t1;

    //private TextView mPlaceDetailsText;

    // private TextView mPlaceAttribution;

    //testing putting address in a temp address charsequence
    public static CharSequence address;
    public static String addressString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Register a listener to receive callbacks when a place has been selected or an error has
        // occurred.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // Log.i(TAG, "Place Selected: " + place.getName());

                // Format the returned place's details and display them in the TextView.
                //mPlaceDetailsText.setText(place.getAddress());

                //test placing address into addressTemp
                address = place.getAddress();
                addressString = address.toString();
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
                try {
                    response = yelp.searchByLocation("restaurant", addressString);
                    yp.setResponse(response);
                    yp.parseBusiness();
                    activity = yp.getBusinessName(RandRestaurant);
                    rating = yp.getBusinessRating(RandRestaurant);
                    img_url = yp.getBusinessImageURL(RandRestaurant);
                    System.out.println(yp.getBusinessDistance(RandRestaurant));
                    distance = Math.round(Double.parseDouble(yp.getBusinessDistance(RandRestaurant)) / 162.61) / 10.00;
                    htmlname = "<body><h3>" + activity + "<br></h3>";
                    htmldetail = "<p>" + rating + "<br>" + distance + " mi.</p><br> ";
                    newurl = new URL(img_url);
                    mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());

                } catch (Exception e) {
                    System.out.println("\n\n\nError:" + e.getMessage());
                }//End catch
            }

            @Override
            public void onError(Status status) {
                //Log.e(TAG, "onError: Status = " + status.toString());
                System.out.println("Place selection failed:" + status.getStatusMessage());
            }
        });



        // Retrieve the TextViews that will display details about the selected place.
        //mPlaceDetailsText = (TextView) findViewById(R.id.place_details);
        // mPlaceAttribution = (TextView) findViewById(R.id.place_attribution);


        Button generator = (Button) findViewById(R.id.button);

        //String htmlexample = "<body><h2>The Result<br></h2>";
        //tv.setText(Html.fromHtml(htmlexample, null, null));
        generator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RandRestaurant = ran.nextInt(limit);
                yelp.setLimit(limit);
                t1 = new Thread() {
                    public void run() {
                        try {
                            response = yelp.searchByLocation("restaurant", addressString);
                            yp.setResponse(response);
                            yp.parseBusiness();
                            activity = yp.getBusinessName(RandRestaurant);
                            rating = yp.getBusinessRating(RandRestaurant);
                            img_url = yp.getBusinessImageURL(RandRestaurant);
                            System.out.println(yp.getBusinessDistance(RandRestaurant));
                            distance = Math.round(Double.parseDouble(yp.getBusinessDistance(RandRestaurant)) / 162.61) / 10.00;
                            htmlname = "<body><h3>" + activity + "<br></h3>";
                            htmldetail = "<p>" + rating + "<br>" + distance + " mi.</p><br> ";
                            newurl = new URL(img_url);
                            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());

                        } catch (Exception e) {
                            System.out.println("\n\n\nError:" + e.getMessage());
                        }//End catch
                    }//End run
                }; //End thread
                t1.start();

                try {
                    ImageView iv = (ImageView) findViewById(R.id.imageView);
                    iv.setImageBitmap(mIcon_val);
                } catch (Exception e) {
                    System.out.println("\n\n\nError:" + e.getMessage());
                }//End catch

                try {
                    TextView tv = (TextView) findViewById(R.id.textView2);
                    tv.setText(Html.fromHtml(htmlname));
                } catch (Exception e) {
                    System.out.println("\n\n\nError:" + e.getMessage());
                }//End catch

                try {
                    TextView tv2 = (TextView) findViewById(R.id.textView4);
                    tv2.setText(Html.fromHtml(htmldetail));
                } catch (Exception e) {
                    System.out.println("\n\n\nError:" + e.getMessage());
                }//End catch
            }//End run

        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information
    }



}