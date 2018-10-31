package com.urbanrake.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

public class SplashScreenActivity extends AppCompatActivity {

    TextView Copyright;
    ProgressWheel circularProgressBar;
    ImageView Logo;
    boolean firstime = false;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);


        circularProgressBar = findViewById(R.id.circular);
        Copyright = findViewById(R.id.Copyright);
        Logo = findViewById(R.id.logo);
        circularProgressBar.spin();
        prefs = getSharedPreferences("Urbanrake2017", 0);
        firstime = prefs.getBoolean("Firstime", false);
        if (isNetworkConnected()) {
            //new NetworkAvailabilityTest().execute();
            Log.e("Internet", "available");


            if (!firstime) {
                final Handler handler = new Handler();
                handler.postDelayed(() -> {

                    startActivity(new Intent(SplashScreenActivity.this, IntroActivity.class));
                    overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_medium);
                    finish();
                    circularProgressBar.stopSpinning();

                }, 3500);
            } else {
                final Handler handler = new Handler();
                handler.postDelayed(() -> {

                    startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                    overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_medium);
                    finish();
                    circularProgressBar.stopSpinning();

                }, 3500);

            }


        } else {
            Log.e("Network", "not available");

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    circularProgressBar.setVisibility(View.GONE);

                    AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreenActivity.this);
                    builder.setTitle("Connection Failed");
                    builder.setMessage("Please Check Your Internet Connection And Try Again");
                    builder.setCancelable(false);


                    String positiveText = "OK";
                    builder.setPositiveButton(positiveText,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // positive button logic
                                    finish();
                                }
                            });


                    AlertDialog dialog = builder.create();
                    // display dialog
                    dialog.show();
                }
            }, 1000);


        }

    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }


    private class NetworkAvailabilityTest extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                HttpURLConnection urlc = (HttpURLConnection)
                        (new URL("http://clients3.google.com/generate_204")
                                .openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);

                urlc.connect();
                return (urlc.getResponseCode() == 204 && urlc.getContentLength() == 0);
            } catch (IOException e) {
                Log.e("internet connection", "Error checking internet connection", e);
                return false;

            }


        }

        @Override
        protected void onPostExecute(Boolean result) {

        }


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

}
