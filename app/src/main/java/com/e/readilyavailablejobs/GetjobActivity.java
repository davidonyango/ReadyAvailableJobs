package com.e.readilyavailablejobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private Toolbar mtoolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getjob);

        String [] items = {"Name","Country","Item3","Item4","Item5","Item6","Item7"};


        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Posted Ready Jobs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.list_view);
        databaseReference = FirebaseDatabase.getInstance().getReference("Davido");
        userJobsList = new ArrayList<>();
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
