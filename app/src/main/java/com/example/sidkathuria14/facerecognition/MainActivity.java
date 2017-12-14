package com.example.sidkathuria14.facerecognition;

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
import android.view.View;
import android.widget.Button;

import com.google.android.gms.vision.face.Face;

import java.io.IOException;
import java.io.InputStream;

import static com.example.sidkathuria14.facerecognition.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    private FaceOverlayView mFaceOverlayView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFaceOverlayView = (FaceOverlayView) findViewById(R.id.face_overlay);

        InputStream stream = getResources().openRawResource(R.raw.group);
        Bitmap bitmap = BitmapFactory.decodeStream(stream);

        mFaceOverlayView.setBitmap(bitmap);


    }


    }



