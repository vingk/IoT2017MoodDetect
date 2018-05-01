package com.mooddetect.mooddetectapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by kulka on 2018-04-28.
 * Class to register a user.
 */

public class Register extends Activity{
    Button register;
    Button cancel;
    EditText email,height,weight;
    Context context = this ;
    String TAG = "RegisterActivity";

    /**
     * @param savedInstanceState
     */
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (Button)findViewById(R.id.email_sign_in_button);
        email = (EditText)findViewById(R.id.email);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        cancel = (Button)findViewById(R.id.cancel);

        //onclick listner to detect button click
        register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            // save user details on the mobile device. No need to send it to the server.
                                            SharedPreferences sharedPref = context.getSharedPreferences(
                                                    getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPref.edit();
                                            editor.putString(getString(R.string.user_email), email.getText().toString());
                                            editor.putString(getString(R.string.user_height), height.getText().toString());
                                            editor.putString(getString(R.string.user_weight), weight.getText().toString());
                                            editor.commit();
                                            Toast.makeText(getApplicationContext(), "Saved User", Toast.LENGTH_SHORT).show();

                                            Log.i(TAG, "Registered User, saved to SharedPreferences ");

                                            Log.i(TAG, "Moving intent to Device Setup ");

                                            final Intent intent = new Intent(context, DeviceScanActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );

        cancel.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          finish();
                                      }
                                  }
        );
        finish();
    }
}
