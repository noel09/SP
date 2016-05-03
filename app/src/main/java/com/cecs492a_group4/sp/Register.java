package com.cecs492a_group4.sp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.ProgressBar;
import android.os.Handler;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by root on 2/13/16.
 */
public class Register extends Activity {

    //-------------------------------Declarations-------------------------------
    private Firebase mRef;
    private final String DB_URL =  "https://incandescent-heat-931.firebaseio.com/";
    private ProgressDialog loadingSpinner;
    private int progressBarStatus = 0;
    private Handler progressBarbHandler = new Handler();

    //-------------------------------On Create-------------------------------
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);
        mRef = new Firebase(DB_URL);
    }//End onCreate

    //If cancel button is click, close the registration page
    public void onClickCancelButton(View v){
        this.finish();
    }

    //If register button is clicked, create a new account for the user
    public void onClickRegisterButton(View v){
        setLoadingSpinner(v);
        register(v);

        //Run the spinner until the registration process is done
        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressBarbHandler.post(new Runnable() {
                        public void run() {
                            loadingSpinner.setProgress(progressBarStatus);
                        }
                    });
                }//End while

                if (progressBarStatus >= 100) {
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    loadingSpinner.dismiss();
                }//End if
            }//End run()
        }).start();
    }//End onClickButton

    public void register(View v){
        //Set progress to 0
        progressBarStatus = 0;

        //Declarations
        final EditText email =  (EditText) findViewById(R.id.TFemailRegister);
        final EditText password = (EditText) findViewById(R.id.TFpasswordRegister);
        final EditText passwordTwo = (EditText) findViewById(R.id.TFpasswrodRegisterCon);
        String emailString, passwordString, passwordTwoString;

        //Get user Input
        emailString = email.getText().toString();
        passwordString = password.getText().toString();
        passwordTwoString = passwordTwo.getText().toString();

        //If the inputted passwords are not the same,  display an error prompt
        if( !passwordString.equals(passwordTwoString))
        {
            password.setText("");
            passwordTwo.setText("");
            passwordTwo.setHintTextColor(Color.RED);
            passwordTwo.setHint("Passwords Do Not Match");
        }
        else {
            //Add a new account to the database
            mRef.createUser(emailString, passwordString, new Firebase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> result) {
                    Log.d("Result", "Successfully created user account with uid: " + result.get("uid"));
                    Intent ii = new Intent(Register.this, MainActivity.class);
                    startActivity(ii);
                }
                @Override
                public void onError(FirebaseError firebaseError) {
                    switch (firebaseError.getCode()){
                        case FirebaseError.EMAIL_TAKEN:
                            email.setText("");
                            email.setHintTextColor(Color.RED);
                            email.setHint("Email Address Is Taken");
                            password.setText("");
                            passwordTwo.setText("");
                            break;
                        case FirebaseError.INVALID_EMAIL:
                            email.setText("");
                            email.setHintTextColor(Color.RED);
                            email.setHint("Invalid Email Address");
                            password.setText("");
                            passwordTwo.setText("");
                            break;
                        case FirebaseError.INVALID_PASSWORD:
                            email.setText("");
                            password.setText("");
                            password.setHintTextColor(Color.RED);
                            password.setHint("Invalid Password Pattern");
                            passwordTwo.setText("");
                            break;
                        case FirebaseError.DISCONNECTED:
                            email.setText("");
                            email.setHintTextColor(Color.RED);
                            email.setHint("Please Check Your Connection");
                            password.setText("");
                            passwordTwo.setText("");
                            break;
                        case FirebaseError.NETWORK_ERROR:
                            email.setText("");
                            email.setHintTextColor(Color.RED);
                            email.setHint("Please Check Your Connection");
                            password.setText("");
                            passwordTwo.setText("");
                            break;
                        default:
                            email.setText("");
                            email.setHintTextColor(Color.RED);
                            email.setHint("Unknown Error");
                            password.setText("");
                            passwordTwo.setText("");
                            break;
                    }//End Switch
                }//End onError()
            });//End createUser()
        }//End else
        progressBarStatus = 100;
    }//End Register()

    //Initialize the loading spinner
    public void setLoadingSpinner(View v)
    {
        loadingSpinner = new ProgressDialog(v.getContext());
        loadingSpinner.setCancelable(true);
        loadingSpinner.setMessage("Creating an account for you ...");
        loadingSpinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loadingSpinner.setProgress(0);
        loadingSpinner.setMax(100);
        loadingSpinner.show();
    }//End setLoadingSpinner()
}//End class
