package com.packtpub.masteringopencvandroid.chapter1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    public static final String TAG = "Chapter1::MainActivity";

    private final int SELECT_PHOTO = 1;
    private static int ACTION_MODE = 0;

    private ImageView ivImage, ivImageProcessed;
    private Mat src;

    private BaseLoaderCallback mOpenCVCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    // Do your work here
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        ivImageProcessed = (ImageView) findViewById(R.id.ivImageProcessed);

        Intent intent = getIntent();

        if (intent.hasExtra(HomeActivity.INTENT_STRING)) {
            ACTION_MODE = intent.getIntExtra(HomeActivity.INTENT_STRING, 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_load_image) {
            //Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
            Intent photoPickerIntent = new Intent();

            photoPickerIntent.setType("image/*");
            photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(photoPickerIntent,"Select Any"), SELECT_PHOTO);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK && imageReturnedIntent != null && imageReturnedIntent.getData() != null) {
                    Uri imgUri = imageReturnedIntent.getData();

                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
                        Log.d(TAG, String.valueOf(bitmap));
                        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        //imageView.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
        }
    }
}
