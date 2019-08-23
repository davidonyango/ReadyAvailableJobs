package com.e.readilyavailablejobs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class JobpageActivity extends AppCompatActivity {
    private ImageView imageProfile;
    private Button upload;
    private Button postaJob;
    private Button getJob;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri profileImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobpage);

        if (Build.VERSION.SDK_INT >22){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
        }

        imageProfile = (ImageView)findViewById(R.id.iv_imageprofile_id);
        upload = (Button)findViewById(R.id.bt_upload_id);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btupload();
            }
        });

        postaJob = (Button)findViewById(R.id.bt_postjob_id);
        postaJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btpost();
            }
        });


        getJob = (Button)findViewById(R.id.bt_getjob_id);
        getJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btget();
            }
        });



    }

    private void btget() {


        Intent intent = new Intent(JobpageActivity.this,GetjobActivity.class);
        startActivity(intent);

    }



    private void btpost() {

        Intent intent = new Intent(JobpageActivity.this,JobActivity.class);
        startActivity(intent);
    }

    private void btupload() {

        Intent biuploadIntent = new Intent();
        biuploadIntent.setType("image/*");

        biuploadIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(biuploadIntent,PICK_IMAGE_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            profileImageUri = data.getData();
            imageProfile.setImageURI(profileImageUri);

        }else {

            Toast.makeText(this, "Please choose image", Toast.LENGTH_SHORT).show();

        }
    }
}



