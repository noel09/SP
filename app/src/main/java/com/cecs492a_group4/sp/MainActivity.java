package com.cecs492a_group4.sp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookSdk;


public class MainActivity extends AppCompatActivity {



    private AccessTokenTracker accessTokenTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());



        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                updateWithToken(newAccessToken);
            }

        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(MainActivity.this, login.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, 1000);


    }


    private void updateWithToken(AccessToken currentAccessToken) {
        if (currentAccessToken != null) {
            Intent activity = new Intent(this,SingleEvent.class);
            startActivity(activity);
            MainActivity.this.finish();

        } else {
            Intent login = new Intent(this,login.class);
            startActivity(login);
            MainActivity.this.finish();

        }
    }


}
