package com.cecs492a_group4.sp;


import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * Created by ImanuelK09 on 4/14/16.
 */
public class PopRadius extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_radius);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.25));

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(SingleEvent.currentRadius);
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Radius: " + SingleEvent.currentRadius);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                if(progress < 1){
                    progress = 1;
                }


                SingleEvent.currentRadius = progress;
                textView.setText("Radius: " + SingleEvent.currentRadius);


            }
        });


    }





}