
package com.e.readilyavailablejobs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;


public class JobpageActivity extends AppCompatActivity {
    private ImageView imageProfile;
    private Button upload;
    private Button postaJob;
    private Button getJob;
    private Uri filePath;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobpage);

        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Home Profile");
        setSupportActionBar(mtoolbar);


        imageProfile = (ImageView) findViewById(R.id.iv_imageprofile_id);
        upload = (Button) findViewById(R.id.bt_upload_id);
        postaJob = (Button) findViewById(R.id.bt_postjob_id);
        getJob = (Button) findViewById(R.id.bt_getjob_id);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();




        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btuplod();
            }
        });


        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivprofile();

            }
        });

        postaJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btpost();
            }
        });


        getJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btget();
            }
        });


    }

    private void btuplod() {

        if (filePath != null) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading.....");
            progressDialog.show();

            StorageReference reference = storageReference.child("Images/" + UUID.randomUUID().toString());
            reference.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            progressDialog.dismiss();
                            Toast.makeText(JobpageActivity.this, "Image uploaded Successfuly", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {

                            double progres = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Please wait for a moment" + (int) progres + "%");

                        }
                    });
        }

    }

    private void btget() {

        Intent intent = new Intent(JobpageActivity.this, GetjobActivity.class);
        startActivity(intent);
    }


    private void btpost() {

        Intent intent = new Intent(JobpageActivity.this, JobActivity.class);
        startActivity(intent);

    }

    private void ivprofile() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            filePath = data.getData();

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageProfile.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commonmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.share)

        {
            Toast.makeText(this, "Share menu is clicked", Toast.LENGTH_SHORT).show();
            switch (item.getItemId()){

                case R.id.share:
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody ="https://getreadilyavailablejobs.com/davidoRajApp";
                    String shareSubject = "Your Subject Here";

                    sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

                    startActivity(Intent.createChooser(sharingIntent,"Share Via"));
                    break;
            }

        }
        else
        if (id==R.id.about){

            Toast.makeText(this, "About menu is clicked", Toast.LENGTH_SHORT).show();
        }
        else
        if (id==R.id.logout){

            Toast.makeText(this, "Logout menu is clicked", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);




    }
}





/** if (Build.VERSION.SDK_INT >22){
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
 Picasso.get().load(profileImageUri).into(imageProfile);
 //imageProfile.setImageURI(profileImageUri);


 }else {

 Toast.makeText(this, "Please choose image", Toast.LENGTH_SHORT).show();

 }


 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 getMenuInflater().inflate(R.menu.commonmenu,menu);
 return super.onCreateOptionsMenu(menu);
 }

 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 int id = item.getItemId();

 if (id==R.id.share)

 {
 Toast.makeText(this, "Share menu is clicked", Toast.LENGTH_SHORT).show();
 switch (item.getItemId()){

 case R.id.share:
 Intent sharingIntent = new Intent(Intent.ACTION_SEND);
 sharingIntent.setType("text/plain");
 String shareBody ="https://getreadilyavailablejobs.com/davidoRajApp";
 String shareSubject = "Your Subject Here";

 sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
 sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

 startActivity(Intent.createChooser(sharingIntent,"Share Via"));
 break;
 }

 }
 else
 if (id==R.id.about){

 Toast.makeText(this, "About menu is clicked", Toast.LENGTH_SHORT).show();
 }
 else
 if (id==R.id.logout){

 Toast.makeText(this, "Logout menu is clicked", Toast.LENGTH_SHORT).show();
 }


 return super.onOptionsItemSelected(item);


 }
 }
 **/
