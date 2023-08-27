package com.example.ycfelix.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        toolbar.setTitle("Health Tips");
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_myarrow);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_myarrow);
        getSupportActionBar().setElevation(10.0f);
        getSupportActionBar().setElevation(10.0f);
    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);

        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }
}