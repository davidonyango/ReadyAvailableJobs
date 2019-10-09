package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.List;


public class JobActivity extends AppCompatActivity {
    private EditText txtName, txtCountry,
            txtLocation, txtPhoneNumber, txtJobType,
            txtDuration, txtRequirements;


    private Button submit;
    private Toolbar mtoolbar;

    private  Class<Davido> UserDataUploadClass;


    FirebaseDatabase firebaseDatabase;

     DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Post A Ready Jobs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtName =  findViewById(R.id.et_personname_id);
        txtCountry =  findViewById(R.id.et_personcountry_id);
        txtLocation =  findViewById(R.id.et_personlocation_id);
        txtPhoneNumber =  findViewById(R.id.et_personphonenumber_id);
        txtJobType=  findViewById(R.id.et_personjobtype_id);
        txtDuration =  findViewById(R.id.et_personduration_id);
        txtRequirements =  findViewById(R.id.et_personrequirements_id);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Davido");
        submit = (Button)findViewById(R.id.bt_Submit1_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               sendUserDetailsToServer();


            }
        });


    }

    /**
     * sending the data tto firebase database
     */
    private void sendUserDetailsToServer()
    {

        /**
         * Convert the input details into strings
         */

         String userName = txtName.getText().toString().trim();
         String userCountry = txtCountry.getText().toString().trim();
         String userLocation = txtLocation.getText().toString().trim();
         String userPhoneNumber = txtPhoneNumber.getText().toString().trim();
         String userJob = txtJobType.getText().toString().trim();
         String userJobDuration = txtDuration.getText().toString().trim();
         String userRequirements = txtRequirements.getText().toString().trim();

        /**
         * Setting validations to ensure that the user doesnot leave any space blank
         */
        if (!TextUtils.isEmpty(userName)
          && !TextUtils.isEmpty(userCountry)
          && !TextUtils.isEmpty(userLocation)
          && !TextUtils.isEmpty(userPhoneNumber)
          && !TextUtils.isEmpty(userJob)
          && !TextUtils.isEmpty(userJobDuration)
          && !TextUtils.isEmpty(userRequirements))
        {
            //sending the information to database

            String storeUserData = databaseReference.push().getKey();

            Davido jobsposted = new Davido
                    (storeUserData,userName, userLocation,
                    userPhoneNumber, userJob, userCountry,
                    userJobDuration, userRequirements);

            databaseReference.child(storeUserData).setValue(jobsposted);
            txtName.setText("");
            txtPhoneNumber.setText("");
            txtCountry.setText("");
            txtDuration.setText("");
            txtJobType.setText("");
            txtLocation.setText("");
            txtRequirements.setText("");

            Toast.makeText(this, "Uploaded successfully", Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(this, "Please fill all spaces", Toast.LENGTH_SHORT).show();
        }
    }

}

