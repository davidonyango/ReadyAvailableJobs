package com.e.readilyavailablejobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    private TextView createaccounttext;
    private Button createaccount;
    private TextView logintext;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        createaccounttext = (TextView)findViewById(R.id.tv_clicktocreateacc_id);
        createaccount = (Button)findViewById(R.id.bt_createanaccount_id);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btcreate();

            }
        });

        logintext = (TextView)findViewById(R.id.tv_logintext_id);
        login = (Button)findViewById(R.id.bt_login_id);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btlogin();
            }
        });
    }

    private void btlogin() {

        Intent intent = new Intent(NextActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void btcreate() {

        Intent intent = new Intent(NextActivity.this,DetailsActivity.class);
        startActivity(intent);
    }
}
