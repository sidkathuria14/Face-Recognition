package com.example.sidkathuria14.facerecognition;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

public class Test extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view);
        imageView = (ImageView)findViewById(R.id.imageView);
        InputStream imageStream = getResources().openRawResource(R.raw.best);
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
        imageView.setImageBitmap(bitmap);
    }
}
