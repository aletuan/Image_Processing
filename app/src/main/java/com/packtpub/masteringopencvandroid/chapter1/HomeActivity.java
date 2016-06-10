package com.packtpub.masteringopencvandroid.chapter1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    public final static String TAG = "Chapter1::HomeActivity";
    public final static String INTENT_STRING = "ACTION_MODE";

    public static final int MEAN_BLUR           = 1;
    public static final int MEDIAN_BLUR         = 2;
    public static final int GAUSSIAN_BLUR       = 3;
    public static final int SHARPEN             = 4;
    public static final int DILATE              = 5;
    public static final int ERODE               = 6;
    public static final int THRESHOLD           = 7;
    public static final int ADAPTIVE_THRESHOLD  = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreated is called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bMean, bGaussian, bMedian, bSharpen, bDilate, bErode, bThreshold, bAdaptiveThreshold;
        bMean = (Button) findViewById(R.id.bMean);
        bDilate = (Button) findViewById(R.id.bDilate);
        bErode = (Button) findViewById(R.id.bErode);
        bMedian = (Button) findViewById(R.id.bMedian);
        bSharpen = (Button) findViewById(R.id.bSharpen);
        bGaussian = (Button) findViewById(R.id.bGaussian);
        bThreshold = (Button) findViewById(R.id.bThreshold);
        bAdaptiveThreshold = (Button) findViewById(R.id.bAdaptiveThreshold);

        bMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("ACTION_MODE", MEAN_BLUR);
                startActivity(i);
            }
        });

        bMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, MEDIAN_BLUR);
                startActivity(i);
            }
        });

        bGaussian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, GAUSSIAN_BLUR);
                startActivity(i);
            }
        });

        bSharpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, SHARPEN);
                startActivity(i);
            }
        });

        bDilate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, DILATE);
                startActivity(i);
            }
        });

        bErode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, ERODE);
                startActivity(i);
            }
        });

        bThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, THRESHOLD);
                startActivity(i);
            }
        });

        bAdaptiveThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra(INTENT_STRING, ADAPTIVE_THRESHOLD);
                startActivity(i);
            }
        });
    }
}
