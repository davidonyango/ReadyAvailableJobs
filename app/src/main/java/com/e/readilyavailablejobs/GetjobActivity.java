package com.e.readilyavailablejobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GetjobActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    List<Davido> userJobsList;

    TextView getName,getCountry,getLocatiopn,getPhoneNumber
            ,getJobDescription,getJobDuration,getRequirements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getjob);
        listView = findViewById(R.id.list_view);
        databaseReference = FirebaseDatabase.getInstance().getReference("");
        userJobsList = new ArrayList<>();

        getName = findViewById(R.id.tv_getname_id);
        getCountry = findViewById(R.id.tv_getcountry1_id);
        getLocatiopn = findViewById(R.id.tv_getlocation_id);
        getPhoneNumber = findViewById(R.id.tv_getphonenumber_id);
        getJobDescription = findViewById(R.id.tv_getjobdescription_id);
        getJobDuration = findViewById(R.id.tv_getdescribethetermsofemployment);
        getRequirements = findViewById(R.id.tv_getskillsandrequrements_id);

        Intent intent = getIntent();

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot userJobsSnapshot : dataSnapshot.getChildren()) {

                    Davido userJobs = userJobsSnapshot.getValue(Davido.class);
                    userJobsList.add(userJobs);
                }
                MyAdapter myAdapter = new MyAdapter(GetjobActivity.this, userJobsList);
                listView.setAdapter(myAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
