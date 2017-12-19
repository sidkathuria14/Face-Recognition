package com.example.sidkathuria14.facerecognition;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.vision.face.Face;

import java.io.IOException;
import java.io.InputStream;

import static com.example.sidkathuria14.facerecognition.R.id.imageView;

public class MainActivity extends Activity {

    private FaceOverlayView mFaceOverlayView;
public static final String TAG1 = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFaceOverlayView = (FaceOverlayView) findViewById(R.id.face_overlay);
        Log.d(TAG1, "onCreate: " + "main activity");

//        InputStream stream = getResources().openRawResource(R.raw.group);
//        Bitmap bitmap = BitmapFactory.decodeStream(stream);
//
//        Bundle extras = getIntent().getExtras();
//        byte[] byteArray = extras.getByteArray("picture");
// byte[] byteArray = getIntent().getByteArrayExtra("picture");
String input = getIntent().getStringExtra("picture");
       Bitmap bitmap =  decodeBase64(input);

//        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.imageView);

     image.setImageBitmap(bitmap);

        mFaceOverlayView.setBitmap(bitmap);
//        Log.d(TAG1, "onCreate: " + byteArray.length);


    }
    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }


    }



