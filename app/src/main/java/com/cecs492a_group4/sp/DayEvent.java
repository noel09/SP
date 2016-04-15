package com.cecs492a_group4.sp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
    String rating, url;


    public DayEvent(String activity_title, URL activity_iconURL, URL activity_rating, String activity_criteria, double distance, String webURL) throws IOException {
        super();
        this.activitytitle = activity_title;
        this.Imageurl = activity_iconURL;
        this.url = webURL;
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
