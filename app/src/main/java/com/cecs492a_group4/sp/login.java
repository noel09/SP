package com.cecs492a_group4.sp;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.util.Log;

import com.facebook.FacebookException;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.AuthData;
import com.facebook.FacebookSdk;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginResult;
import com.facebook.FacebookCallback;
import com.facebook.CallbackManager;
import com.facebook.AccessToken;

public class login extends AppCompatActivity {


    Firebase mRef;
    public static final String DB_URL = "https://incandescent-heat-931.firebaseio.com/";
    private CallbackManager callbackManager;
    private LoginButton FbLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        FbLoginButton = (LoginButton) findViewById(R.id.FBlogin_button);


        FbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                onFacebookAccessTokenChange(AccessToken.getCurrentAccessToken());
            }

            @Override
            public void onCancel() {}

            @Override
            public void onError(FacebookException error) {}
        });

        mRef = new Firebase(DB_URL);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void onFacebookAccessTokenChange(AccessToken token) {
        if (token != null) {
            mRef.authWithOAuthToken("facebook", token.getToken(), new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    Intent main = new Intent(login.this, SingleEvent.class);
                    startActivity(main);
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {

                }
            });
        } else {
        /* Logged out of Facebook so do a logout from the Firebase app */
            mRef.unauth();
        }
    }



    public void onButtonClick(View v){
        if (v.getId() == R.id.BTregister){
            Intent i = new Intent(this,Register.class);
            startActivity(i);
        }
        if (v.getId() == R.id.BLogin) {
            EditText e = (EditText) findViewById(R.id.TFemailLogin);
            String email = e.getText().toString();
            final EditText p = (EditText) findViewById(R.id.TFloginPassword);
            final String password = p.getText().toString();
            Log.d("email: ",email);
            Log.d("password: ",password);
            mRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                    Log.d("Result: ", "Succesfully Logged in");
                    Intent main = new Intent(login.this,SingleEvent.class);
                    startActivity(main);
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    p.setText("");
                    p.setHint("Wrong Password");
                    p.setHintTextColor(Color.RED);
                    Log.d("Result: ", "Login Failed");
                }
            });

        }
    }


}
