package com.example.sidkathuria14.facerecognition;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class ChooseImageActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 234;
    private Uri filePath;
    ImageView imageView;
    Bitmap bitmap;
    public static final String TAG = "Face";
SharedPreferences myPrefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);

        imageView = (ImageView) findViewById(R.id.imageView);
                ((Button) findViewById(R.id.choose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();
            }
        });
        ((Button) findViewById(R.id.detect)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bitmap bmp = BitmapFactory.decodeFile (bitmap);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
//
//                Log.d(TAG, "onClick: " + byteArray.length);
//                SharedPreferences myPrefrence = getSharedPreferences("myPrefs",MODE_PRIVATE);
//                SharedPreferences.Editor editor = myPrefrence.edit();
//                editor.putString("namePreferance", "mybitmap");
//                editor.putString("imagePreferance", encodeTobase64(bitmap));
//                editor.commit();



                Intent intent = new Intent(ChooseImageActivity.this,MainActivity.class);
//                intent.putExtra("picture",encodeTobase64(bitmap));
                intent.putExtra("picture",byteArray);
                startActivity(intent);
            }
        });

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                 bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    public static String encodeTobase64(Bitmap image) {
//        Bitmap immage = image;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] b = baos.toByteArray();
//        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
//
//        Log.d("Image Log:", imageEncoded);
//        return imageEncoded;
//    }
}


