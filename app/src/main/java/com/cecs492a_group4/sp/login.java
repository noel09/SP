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
//
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.AuthData;


public class login extends AppCompatActivity {


    Firebase mRef;
    public static final String DB_URL = "https://incandescent-heat-931.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);


        mRef = new Firebase(DB_URL);



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
