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
    String activitytitle;
    URL Imageurl, rating_url ;
    Bitmap Iconimg, ratingimg;
    String rating;

    public DayEvent(String activity_title, URL activity_iconURL, URL activity_rating, String activity_criteria) throws IOException {
        super();
        this.activitytitle = activity_title;
        this.Imageurl = activity_iconURL;
        Iconimg = BitmapFactory.decodeStream(Imageurl.openConnection().getInputStream());
        this.rating_url = activity_rating;
        ratingimg = BitmapFactory.decodeStream(rating_url.openConnection().getInputStream());
        this.criteria = activity_criteria;
    }

    public String getActivitytitle() {
        return activitytitle;
    }

    public URL getImageurl() {
        return Imageurl;
    }

    public String getCriteria() { return criteria; }
}
