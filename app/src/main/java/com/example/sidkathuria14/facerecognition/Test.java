package com.example.sidkathuria14.facerecognition;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

public class Test extends AppCompatActivity {
ImageView imageView;
    FaceOverlayView mFaceOverlayView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFaceOverlayView = (FaceOverlayView) findViewById(R.id.face_overlay);
        imageView = (ImageView)findViewById(R.id.imageView);

        InputStream imageStream = getResources().openRawResource(R.raw.group);
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);

//        imageView.setImageBitmap(bitmap);
        mFaceOverlayView.setBitmap(bitmap);

    }
}
