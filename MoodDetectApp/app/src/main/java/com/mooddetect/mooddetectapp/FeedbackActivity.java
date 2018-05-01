package com.mooddetect.mooddetectapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class FeedbackActivity extends Activity {

    private RequestQueue queue;
    private String heartRate;
    private String detected;
    private TextView hrField;
    private TextView detectedField;
    private TextView userNameField;
    private String username;
    private String TAG= "FeedbackActivity";
    private TextView humidityField;
    private TextView responseField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        queue = Volley.newRequestQueue(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        username = preferences.getString(getString(R.string.user_email), "no username");
        final Intent intent = getIntent();
        heartRate = intent.getStringExtra("HEART_RATE");
        detected = intent.getStringExtra("DETECTED_MOOD");
        hrField = (TextView) findViewById(R.id.fheartrate);
        detectedField = (TextView) findViewById(R.id.fdetected);
        userNameField =  (TextView) findViewById(R.id.fusername);
        humidityField = (TextView) findViewById(R.id.fhumidity);
        humidityField = (TextView) findViewById(R.id.fresponse);
        userNameField.setText(username);
        hrField.setText(heartRate);
        detectedField.setText(detected);


        String url = "http://api.openweathermap.org/data/2.5/weather?q=Edmonton,CA&appid=329a74454914cbe5e2e0201b10038cf6";
        StringRequest weatherRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseField.setText("Weather No Response!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(weatherRequest);
    }


    //Post feedback that mood is negative
    public void negativeMood(View view){
        String url = "http://204.209.76.212:8080/MoodDetect/WekaRequester";
        StringRequest negativeRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseField.setText(""+response);
                        Log.i(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseField.setText("Server No Response!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(negativeRequest);
    }

    //post feedback that moos is positive
    public void positiveMood(View view){
        String url = "http://204.209.76.212:8080/MoodDetect/WekaRequester";
        StringRequest positiveRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        responseField.setText(""+response);
                        Log.i(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseField.setText("Server No Response!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(positiveRequest);
    }
}
