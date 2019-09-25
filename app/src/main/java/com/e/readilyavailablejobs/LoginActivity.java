package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView enterDetailshere;
    private EditText entphonenumber;
    private EditText entusername;
    private EditText entpassword;
    private Button submit2;
    private Button ctreateaccount;
    private TextView accountRequst;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        accountRequst = (TextView)findViewById(R.id.tv_accountrequest_id);
        enterDetailshere = (TextView)findViewById(R.id.tv_enterdetailshere_id);
        entphonenumber = (EditText) findViewById(R.id.et_enterphonenumber_id);
        entusername = (EditText)findViewById(R.id.et_enterusername_id);
        entpassword = (EditText)findViewById(R.id.et_enterpassword_id);

        submit2 = (Button)findViewById(R.id.bt_submit2_id);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submt();

            }
        });


        ctreateaccount = (Button)findViewById(R.id.bt_createaccount_id);
        ctreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createaccnt();

            }
        });
    }

    private void createaccnt() {

        Intent intent = new Intent(LoginActivity.this,DetailsActivity.class);
        startActivity(intent);
    }

    private void submt() {
        Intent intent = new Intent(LoginActivity.this,JobpageActivity.class);
        startActivity(intent);
    }
}
