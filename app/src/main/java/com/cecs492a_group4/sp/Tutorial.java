package com.cecs492a_group4.sp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ImanuelK09 on 5/12/16.
 */
public class Tutorial extends Activity {

    ArrayList<Integer> imgSrc = new ArrayList<Integer>();
    int imgCounter = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_fragment);

        final ImageView ivTutorial = (ImageView) findViewById(R.id.imgTutorial);

        Button btnTutBack = (Button) findViewById(R.id.btnTutBack);
        Button btnTutNext = (Button) findViewById(R.id.btnTutNext);

        //Load the images to the arraylist

        //imgSrc.add(getResources().getIdentifier("custom_addr01", "drawable", getPackageName()));
        imgSrc.add(R.drawable.custom_addr01);
        imgSrc.add(R.drawable.custom_addr02);
        imgSrc.add(R.drawable.custom_addr03);
        imgSrc.add(R.drawable.current_loc01);
        imgSrc.add(R.drawable.current_loc02);
        imgSrc.add(R.drawable.generate_plan01);
        imgSrc.add(R.drawable.generate_plan02);
        imgSrc.add(R.drawable.generate_plan03);
        imgSrc.add(R.drawable.generate_plan04);
        imgSrc.add(R.drawable.modify_plan01);
        imgSrc.add(R.drawable.modify_plan02);
        imgSrc.add(R.drawable.modify_plan03);
        imgSrc.add(R.drawable.modify_plan04);
        imgSrc.add(R.drawable.radius_filt01);
        imgSrc.add(R.drawable.radius_filt02);
        imgSrc.add(R.drawable.share_loc01);
        imgSrc.add(R.drawable.share_loc02);
        imgSrc.add(R.drawable.call_loc01);
        imgSrc.add(R.drawable.call_loc02);
        imgSrc.add(R.drawable.get_direction01);
        imgSrc.add(R.drawable.get_direction02);
        imgSrc.add(R.drawable.yelp_page01);
        imgSrc.add(R.drawable.yelp_page02);

        Drawable imgTemp = getResources().getDrawable(imgSrc.get(0));

        ivTutorial.setImageDrawable(imgTemp);

        btnTutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imgCounter < imgSrc.size()-1) {
                    imgCounter++;
                    Drawable imgTemp = getResources().getDrawable(imgSrc.get(imgCounter));
                    ivTutorial.setImageDrawable(imgTemp);
                } else {
                    Drawable imgTemp = getResources().getDrawable(imgSrc.get(imgCounter));
                    ivTutorial.setImageDrawable(imgTemp);
                }
            }
        });

        btnTutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCounter > 0){
                    imgCounter--;
                    Drawable imgTemp = getResources().getDrawable(imgSrc.get(imgCounter));
                    ivTutorial.setImageDrawable(imgTemp);
                }
                else{
                    Drawable imgTemp = getResources().getDrawable(imgSrc.get(imgCounter));
                    ivTutorial.setImageDrawable(imgTemp);
                }
            }
        });
    }
}
