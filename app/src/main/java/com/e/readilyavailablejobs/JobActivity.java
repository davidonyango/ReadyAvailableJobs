package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
    private EditText enterYourName, enterYourCountry1,
            dscribeLocation1, enterPhoneNumber, jobDescription,
            theEmploymentDuration, describeRequirements;

    private Button submit, homePage;

    private  Class<Davido> UserDataUploadClass;


    FirebaseDatabase firebaseDatabase;

     DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);



        enterYourName = (EditText) findViewById(R.id.et_enteryourname_id);
        enterYourCountry1 = (EditText) findViewById(R.id.et_enteryourcountry1_id);
        dscribeLocation1 = (EditText) findViewById(R.id.et_describelocation1_id);
        enterPhoneNumber = (EditText) findViewById(R.id.et_enterphonenumber2_id);
        jobDescription= (EditText) findViewById(R.id.et_jobdescription_id);
        theEmploymentDuration = (EditText) findViewById(R.id.et_theemploymentduration_id);
        describeRequirements = (EditText) findViewById(R.id.et_describerequirements_id);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("User details");
        submit = (Button)findViewById(R.id.bt_Submit1_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               sendUserDetailsToServer();


            }
        });

        homePage = (Button)findViewById(R.id.bt_homepage_id);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bthomepage();
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

        String userName = enterYourName.getText().toString().trim();
         String userCountry = enterYourCountry1.getText().toString().trim();
         String userLocation = dscribeLocation1.getText().toString().trim();
         String userPhoneNumber = enterPhoneNumber.getText().toString().trim();
        String userJob = jobDescription.getText().toString().trim();
        String userJobDuration = theEmploymentDuration.getText().toString().trim();
         String userRequirements = describeRequirements.getText().toString().trim();

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

            Davido UserDataUploadClass = new Davido
                    (storeUserData,userName, userLocation,
                    userPhoneNumber, userJob, userCountry,
                    userJobDuration, userRequirements);

            databaseReference.child(storeUserData).setValue(UserDataUploadClass);
            enterYourName.setText("");
            enterPhoneNumber.setText("");
            enterYourCountry1.setText("");
            theEmploymentDuration.setText("");
            jobDescription.setText("");
            describeRequirements.setText("");
            dscribeLocation1.setText("");

            Toast.makeText(this, "Uploaded successfully", Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(this, "Please fill all spaces", Toast.LENGTH_SHORT).show();
        }
    }

    private void bthomepage() {

        Intent intent = new Intent(JobActivity.this,JobpageActivity.class);
        startActivity(intent);
    }
}

