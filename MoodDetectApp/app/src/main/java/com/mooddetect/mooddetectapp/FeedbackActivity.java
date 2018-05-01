package com.mooddetect.mooddetectapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FeedbackActivity extends Activity {

    private RequestQueue queue;
    private String heartRate;
    private String detected;
    private TextView hrField;
    private TextView detectedField;
    private TextView userNameField;
    private String username;
    private String TAG = "FeedbackActivity";
    private TextView humidityField;
    private TextView temperatureField;
    private TextView pressureField;
    private TextView cloudinessField;
    private TextView windinessField;
    private TextView responseField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        queue = Volley.newRequestQueue(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        username = preferences.getString(getString(R.string.user_email), "Enter email");
        final Intent intent = getIntent();
        heartRate = intent.getStringExtra("HEART_RATE");
        detected = intent.getStringExtra("DETECTED_MOOD");
        hrField = (TextView) findViewById(R.id.fheartrate);
        detectedField = (TextView) findViewById(R.id.fdetected);
        userNameField = (TextView) findViewById(R.id.fusername);
        humidityField = (TextView) findViewById(R.id.fhumidity);
        cloudinessField = (TextView) findViewById(R.id.fcloud);
        windinessField = (TextView) findViewById(R.id.fwindiness);
        temperatureField = (TextView) findViewById(R.id.ftemperature);
        pressureField = (TextView) findViewById(R.id.fpressure);
        responseField = (TextView) findViewById(R.id.fresponse);
        userNameField.setText(username);
        hrField.setText(heartRate);
        detectedField.setText(detected);

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        @SuppressLint("MissingPermission") Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String url = "http://api.openweathermap.org/data/2.5/weather?lat="+String.valueOf(latitude)+"&lon="+String.valueOf(longitude)+"&appid=329a74454914cbe5e2e0201b10038cf6";
        StringRequest weatherRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        if(response!=null){
                            try {
                                JSONObject resp = new JSONObject(response);
                                JSONObject main = resp.optJSONObject("main");
                                String valHumidity = main.optString("humidity");
                                String valTemp = main.optString("temp");
                                String valPressure = main.optString("pressure");
                                humidityField.setText(valHumidity);
                                temperatureField.setText(valTemp);
                                pressureField.setText(valPressure);
                                JSONObject wind = resp.optJSONObject("wind");
                                String valWind = wind.optString("speed");
                                windinessField.setText(valWind);
                                JSONObject cloud = resp.optJSONObject("clouds");
                                String valCloud = cloud.optString("all");
                                cloudinessField.setText(valCloud);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                        Log.i(TAG, response.toString());
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

        }

        ){
            @Override
            protected Map<String, String> getParams() {
                //set post params
                Map<String, String> params = new HashMap<String, String>();
                params.put("USER_NAME", userNameField.getText().toString());
                params.put("HEART_RATE", hrField.getText().toString());
                params.put("DETECTED", detectedField.getText().toString());
                params.put("TEMP", temperatureField.getText().toString());
                params.put("HUMID", humidityField.getText().toString());
                params.put("CLOUD", cloudinessField.getText().toString());
                params.put("WIND", windinessField.getText().toString());
                params.put("PRESS", pressureField.getText().toString());
                params.put("GT","Negative");
                return params;
            }
        };

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
        }){
            @Override
            protected Map<String, String> getParams() {
                //set post params
                Map<String, String> params = new HashMap<String, String>();
                params.put("USER_NAME", userNameField.getText().toString());
                params.put("HEART_RATE", hrField.getText().toString());
                params.put("DETECTED", detectedField.getText().toString());
                params.put("TEMP", temperatureField.getText().toString());
                params.put("HUMID", humidityField.getText().toString());
                params.put("CLOUD", cloudinessField.getText().toString());
                params.put("WIND", windinessField.getText().toString());
                params.put("PRESS", pressureField.getText().toString());
                params.put("GT","Positive");
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(positiveRequest);
    }
}
