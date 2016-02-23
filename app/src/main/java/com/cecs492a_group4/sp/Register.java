package com.cecs492a_group4.sp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by root on 2/13/16.
 */
public class Register extends Activity {

    Firebase mRef;
    String DB_URL =  "https://incandescent-heat-931.firebaseio.com/";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);

        mRef = new Firebase(DB_URL);
    }


    public void onClickButton(View v){
        if (v.getId() == R.id.BbackToLogin){
            this.finish();
        }
        if (v.getId() == R.id.BTcreateAccount){
            final EditText email =  (EditText) findViewById(R.id.TFemailRegister);
            String emailString = email.getText().toString();
            final EditText password = (EditText) findViewById(R.id.TFpasswordRegister);
            String passwordString = password.getText().toString();
            final EditText passwordTwo = (EditText) findViewById(R.id.TFpasswrodRegisterCon);
            String passwordTwoString = passwordTwo.getText().toString();
            if( !passwordString.equals(passwordTwoString))
            {
                password.setText("");
                passwordTwo.setText("");
                passwordTwo.setHintTextColor(Color.RED);
                passwordTwo.setHint("Password Did Not Match");
            }
            else {
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
                                email.setHint("Email Address Already Registered");
                                password.setText("");
                                passwordTwo.setText("");
                                System.out.println("Failed to created user account Email already registered");
                                break;
                            case FirebaseError.INVALID_EMAIL:
                                email.setText("");
                                email.setHintTextColor(Color.RED);
                                email.setHint("Email Address Invalid");
                                password.setText("");
                                passwordTwo.setText("");
                                System.out.println("Failed to created user account invalid email");
                                break;

                        }



                    }
                });
            }



        }
    }




}
