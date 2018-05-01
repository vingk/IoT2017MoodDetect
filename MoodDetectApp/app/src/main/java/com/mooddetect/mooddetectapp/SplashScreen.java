package com.mooddetect.mooddetectapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by kulka on 2018-04-28.
 */

public class SplashScreen extends Activity{

    private String mDeviceName;
    private String mDeviceAddress;
    private String mUser;
    private String mHeight;
    private String mWeight;
    String TAG = "SplashActivity";

    /**
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //read shared preference from the phone to check if user is alred registered.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mDeviceName = preferences.getString(getString(R.string.device_name), null);
        mDeviceAddress = preferences.getString(getString(R.string.device_address), null);
        mUser = preferences.getString(getString(R.string.user_email), null);
        mHeight = preferences.getString(getString(R.string.user_weight), null);
        mWeight = preferences.getString(getString(R.string.user_weight), null);

        // if no registration is found, redirect to registration page
        Toast.makeText(getApplicationContext(), mUser +" "+ mDeviceName, Toast.LENGTH_LONG).show();
        if(mUser == null || mHeight ==null || mWeight==null){
            Log.i(TAG, "User not registered, going to Registration screen");
            final Intent intent = new Intent(this, Register.class);
            startActivity(intent);
            finish();

        }

        //if blueetooth device has not been setup yet, redirect to device setup
        if(mDeviceAddress==null || mDeviceName==null){
            Log.i(TAG, "Bluetooth device not registered, moving to Device setup screen");
            final Intent intent = new Intent(this, DeviceScanActivity.class);
            startActivity(intent);
            finish();
        }

        // if user and device have been setup, redirect to main thread.
        Log.i(TAG, "User info and Device info exists, moving to Device control");
        final Intent intent = new Intent(this, DeviceControlActivity.class);
        startActivity(intent);
        finish();
    }

}