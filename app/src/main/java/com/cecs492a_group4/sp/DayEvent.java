package com.cecs492a_group4.sp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Abdullah on 3/20/16.
 */
public class DayEvent {
    String criteria;
    double distance;
    String activitytitle;
    URL Imageurl, rating_url ;
    Bitmap Iconimg, ratingimg;
    String rating, url, phoneNumber, address;



    public DayEvent(String activity_title, URL activity_iconURL, URL activity_rating, String activity_criteria, double distance, String webURL, String number, String address) throws IOException {
        super();
        this.activitytitle = activity_title;
        this.Imageurl = activity_iconURL;
        this.url = webURL;
        this.phoneNumber = number;
        this.address = address;
        try{

            Iconimg = BitmapFactory.decodeStream(Imageurl.openConnection().getInputStream());


        }catch (Exception e)
        {
            Iconimg = null;
        }

        this.rating_url = activity_rating;
        try{
            ratingimg = BitmapFactory.decodeStream(rating_url.openConnection().getInputStream());
        }catch (Exception e)
        {
            Iconimg = null;
        }

        this.criteria = activity_criteria;
        this.distance = distance;
    }

    public String getActivitytitle() {
        return activitytitle;
    }

    public URL getImageurl() {
        return Imageurl;
    }

    public Bitmap getIconimg() { return Iconimg; }

    public String getCriteria() { return criteria; }


}

